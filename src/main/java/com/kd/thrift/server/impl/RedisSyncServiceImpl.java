package com.kd.thrift.server.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.tools.redissync.Sync;


public class RedisSyncServiceImpl implements com.kd.redissync.thrift.RedisSyncService.Iface {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisSyncServiceImpl.class);
	private static Map<String, Sync> syncServiceMap = new HashMap<>();

	static {
		syncServiceMap.put("EntBasicInfoSync", new com.kd.sync.EntBasicInfoSync());
		syncServiceMap.put("EntAbnormalItemSync", new com.kd.sync.EntAbnormalItemSync());
		syncServiceMap.put("EntBranchSync", new com.kd.sync.EntBranchSync());
		syncServiceMap.put("EntChgRecordSync", new com.kd.sync.EntChgRecordSync());
		syncServiceMap.put("EntEquitySync", new com.kd.sync.EntEquitySync());
		syncServiceMap.put("EntSoftCopyrightsSync", new com.kd.sync.EntSoftCopyrightsSync());
		syncServiceMap.put("SyncSupervisor", new com.kd.sync.SyncSupervisor());
		syncServiceMap.put("SupervisorEntSync", new com.kd.sync.SupervisorEntSync());
		syncServiceMap.put("SupervisorStockSync", new com.kd.sync.SupervisorStockSync());
		syncServiceMap.put("TopicEventSync", new com.kd.sync.TopicEventSync());
	}

	@Override
	public String sync(String sync_job_name) throws TException {
		Sync syncJob = syncServiceMap.get(sync_job_name);
		if (syncJob == null) {
			String errorInfo = String.format("sync job [%s] not exist!", sync_job_name);
			LOGGER.error(errorInfo);
			throw new TException(errorInfo);
		}

		syncJob.doSync();

		return "success";
	}

	//全量同步接口
	@Override
	public String resync(String sync_job_name) throws TException {
		Sync syncJob = syncServiceMap.get(sync_job_name);
		if (syncJob == null) {
			String errorInfo = String.format("sync job [%s] not exist!", sync_job_name);
			LOGGER.error(errorInfo);
			throw new TException(errorInfo);
		}

		syncJob.doFullSync();

		return "success";
	}
}
