package com.kd.sync;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.RptToeMa;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class RptToeMaSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(RptToeMaSync.class);

	@Override
	public void doSync() {
		try {
			long start = System.currentTimeMillis();
			String sql = "select * from rpt_toe_ma order by ma_id desc limit 300;";

			List<RptToeMa> list = RptToeMa.dao.find(sql);

			HashMap<String, Object> map = new HashMap<String, Object>();

			if (list != null) {

				map.put(RedisPrexConst.RptToeMaSync, list);

				JedisObjectUtil.pipelineData(map);
			}

			long end = System.currentTimeMillis();
			logger.info("sync all RptToeMaSync info to redis cost time:" + (end - start));
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
		JedisObjectUtil.batchDelData(RedisPrexConst.RptToeMaSync);
	}

}
