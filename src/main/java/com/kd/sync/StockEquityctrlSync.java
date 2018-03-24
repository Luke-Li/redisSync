package com.kd.sync;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.StockEquityctrl;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class StockEquityctrlSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(StockEquityctrlSync.class);

	@Override
	public void doSync() {
		try {
			long start = System.currentTimeMillis();

			List<StockEquityctrl> list = StockEquityctrl.dao
					.find(String.format("select * from %s", StockEquityctrl.TableName));

			HashMap<String, Object> map = new HashMap<String, Object>();

			if (list != null) {
				for (StockEquityctrl record : list) {
					String key = String.format("%s%s%s", RedisPrexConst.StockEquityCtrlSync, RedisPrexConst.SEPARATOR,
							record.getStockCode());
					map.put(key, record);
				}
				JedisObjectUtil.pipelineData(map);
			}
			map.clear();
			long end = System.currentTimeMillis();
			logger.info("sync all StockEquityctrlSync info to redis cost time:" + (end - start));
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
		String key = String.format("%s%s", RedisPrexConst.StockEquityCtrlSync, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
