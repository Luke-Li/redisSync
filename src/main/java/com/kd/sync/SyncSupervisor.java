package com.kd.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.tools.redissync.Sync;


public class SyncSupervisor implements Sync{

	private static final Logger logger = LoggerFactory.getLogger(SyncSupervisor.class);
	@Override
	public void doSync() {
		//企业
		long start = System.currentTimeMillis();
//		clearData();
		new SupervisorEntSync().doSync();
		new SupervisorStockSync().doSync();
		
		long end = System.currentTimeMillis();
		System.out.println("Sync all data total used time: " + (end-start));
		logger.info("Sync all data total used time: " + (end-start));
	}

	@Override
	public void doFullSync() {
		clearData();
		doSync();
	}


	@Override
	public void clearData() {
		new SupervisorEntSync().clearData();
		new SupervisorStockSync().clearData();
	}

}
