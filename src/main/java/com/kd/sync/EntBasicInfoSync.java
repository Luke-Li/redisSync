package com.kd.sync;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.EntBasicInfo;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class EntBasicInfoSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(EntBasicInfoSync.class);

	@Override
	public void doSync() {
		try {
			int count =0;
			int from = 0;
			String tmpEntId = "0";
			long start = System.currentTimeMillis();

			while (true) {
				List<EntBasicInfo> list = EntBasicInfo.dao
						.find(String.format("select * from %s where ent_id>'%s' order by ent_id limit %d", EntBasicInfo.TableName,tmpEntId, RedisPrexConst.STEP));

				HashMap<String, Object> map = new HashMap<String, Object>();

				if (list != null) {
					for (EntBasicInfo record : list) {
						String key = String.format("%s%s%s", RedisPrexConst.EntBasicInfoSync, RedisPrexConst.SEPARATOR,
								record.getEntId());
						map.put(key, record);
						tmpEntId = record.getEntId();
						count++;
					}
					from = from + RedisPrexConst.STEP;
					JedisObjectUtil.pipelineData(map);
				}
				if(map.isEmpty() || count < from){
					break;
				}
				map.clear();
			}
			long end = System.currentTimeMillis();
			logger.info("sync all EntBasicInfoSync info to redis cost time:" + (end - start));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public void doFullSync() {
		clearData();
		doSync();
	}

	@Override
	public void clearData() {
		// TODO Auto-generated method stub
		String key = String.format("%s%s", RedisPrexConst.EntBasicInfoSync, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
