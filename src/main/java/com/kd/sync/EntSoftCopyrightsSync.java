package com.kd.sync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.EntSoftCopyrights;
import com.kd.tools.redissync.Sync;
import com.kd.utils.JedisObjectUtil;

public class EntSoftCopyrightsSync implements Sync {

	private static final Logger logger = LoggerFactory.getLogger(EntSoftCopyrightsSync.class);

	@Override
	public void doSync() {
		try {
			long start = System.currentTimeMillis();
			List<EntSoftCopyrights> list = EntSoftCopyrights.dao.find(String.format("select * from %s", EntSoftCopyrights.TableName));

			HashMap<String, Object> map = new HashMap<String, Object>();

			if(list != null){
				for(EntSoftCopyrights record:list){
					String key = String.format("%s%s%s", RedisPrexConst.EntSoftCopyrightsSync, RedisPrexConst.SEPARATOR, record.getUuid());
					List<EntSoftCopyrights> tmpList = (ArrayList<EntSoftCopyrights>)map.get(key);
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
			logger.info("sync all EntSoftCopyrightsSync info to redis cost time:"+(end-start));
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
		String key = String.format("%s%s", RedisPrexConst.EntSoftCopyrightsSync, RedisPrexConst.SEPARATOR);
		JedisObjectUtil.batchDelData(key);
	}

}
