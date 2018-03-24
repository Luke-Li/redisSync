package com.kd.sync;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.kd.consts.RedisPrexConst;
import com.kd.model.general.EntGeneralObject;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;
import com.kd.utils.StringUtil;

public class EntGeneralObjectSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(EntGeneralObjectSync.class);

	public EntGeneralObjectSync(String tableName, String storeKey) {
		super();
		if (!StringUtil.isNullOrEmpty(tableName)) {
			this.tableName = tableName;
			className = storeKey;
		}
	}

	private String tableName;
	private String className;

	@Override
	public void doSync() {
		logger.info(String.format("start to sync %s info!!", className));

		try {
			long start = System.currentTimeMillis();

			HashMap<String, Object> map = new HashMap<String, Object>();
			int from = 0;
			int count = 0;
			String tmpEnt = "0";

			while (true) {

				String sql = String.format("select * from %s where uuid>'%s' order by uuid limit %d", tableName, tmpEnt,
						RedisPrexConst.STEP);
				java.util.List<Record> list = Db.find(sql);

				if (list != null) {
					for (Record record : list) {
						EntGeneralObject objectItem = new EntGeneralObject();
						objectItem.setUuid(record.getStr("uuid"));
						objectItem.setRecord(record.getStr("record"));

						if (!StringUtils.isEmpty(objectItem.getUuid())) {
							String key = String.format("%s%s%s", className, RedisPrexConst.SEPARATOR,
									objectItem.getUuid());
							map.put(key, objectItem);
						}
						count++;
						tmpEnt = objectItem.getUuid();
						objectItem = null;
					}
					JedisObjectUtil.pipelineData(map);
					from = from + RedisPrexConst.STEP;
					if (map.isEmpty() || count < from) {
						logger.info(String.format("count is %d and from is %d", count, from));
						break;
					}
					map.clear();
				}
			}
			long end = System.currentTimeMillis();
			logger.info(String.format("sync all %s info to redis cost time:%d, total record :%d", className,
					(end - start), count));
		} catch (Exception ex) {
			logger.error("", ex);
		}

	}

	@Override
	public void doFullSync() {
		clearData();
		doSync();

	}

	@Override
	public void clearData() {
		String key = String.format("%s%s", className, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
