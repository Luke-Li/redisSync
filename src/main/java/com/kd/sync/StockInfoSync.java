package com.kd.sync;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.StockInfo;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class StockInfoSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(StockInfoSync.class);

	@Override
	public void doSync() {
		try {
			long start = System.currentTimeMillis();

			List<StockInfo> list = StockInfo.dao
					.find(String.format("select * from %s ", StockInfo.TableName));

			HashMap<String, Object> map = new HashMap<String, Object>();

			if (list != null) {
				for (StockInfo record : list) {
					String key = String.format("%s%s%s", RedisPrexConst.StockInfoSync, RedisPrexConst.SEPARATOR,
							record.getStockCode());
					map.put(key, record);
				}
				JedisObjectUtil.pipelineData(map);
			}
			map.clear();
			long end = System.currentTimeMillis();
			logger.info("sync all StockInfoSync info to redis cost time:" + (end - start));
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
		String key = String.format("%s%s", RedisPrexConst.StockInfoSync, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
