package com.kd.sync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.StockManageTeam;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class StockManageTeamSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(StockManageTeamSync.class);

	@Override
	public void doSync() {
		try {
			long start = System.currentTimeMillis();
			List<StockManageTeam> list = StockManageTeam.dao.find(String.format("select * from %s", StockManageTeam.TableName));

			HashMap<String, Object> map = new HashMap<String, Object>();

			if(list != null){
				for(StockManageTeam record:list){
					String key = String.format("%s%s%s", RedisPrexConst.StockManageTeamSync, RedisPrexConst.SEPARATOR, record.getStockCode());
					List<StockManageTeam> tmpList = (ArrayList<StockManageTeam>)map.get(key);
					if(tmpList == null){
						tmpList = new ArrayList<>();
					}
					tmpList.add(record);
					map.put(key, tmpList);
				}

				JedisObjectUtil.pipelineData(map);
			}
			map.clear();
			long end = System.currentTimeMillis();
			logger.info("sync all StockManageTeamSync info to redis cost time:"+(end-start));
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
		String key = String.format("%s%s", RedisPrexConst.StockManageTeamSync, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
