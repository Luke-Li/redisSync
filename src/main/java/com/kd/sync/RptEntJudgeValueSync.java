package com.kd.sync;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.RptEntJudgeValue;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class RptEntJudgeValueSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(RptEntJudgeValueSync.class);

	@Override
	public void doSync() {
		try {
			int count =0;
			int from = 0;
			String tmpEntId = "0";
			long start = System.currentTimeMillis();

			while (true) {
				List<RptEntJudgeValue> list = RptEntJudgeValue.dao
						.find(String.format("select * from %s where uuid>'%s' order by uuid limit %d", RptEntJudgeValue.TableName,tmpEntId, RedisPrexConst.STEP));

				HashMap<String, Object> map = new HashMap<String, Object>();

				if (list != null) {
					for (RptEntJudgeValue record : list) {
						String key = String.format("%s%s%s", RedisPrexConst.RptEntJudgeValueSync, RedisPrexConst.SEPARATOR,
								record.getUuid());
						map.put(key, record);
						tmpEntId = record.getUuid();
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
			logger.info("sync all RptEntJudgeValueSync info to redis cost time:" + (end - start));
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
		String key = String.format("%s%s", RedisPrexConst.RptEntJudgeValueSync, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
