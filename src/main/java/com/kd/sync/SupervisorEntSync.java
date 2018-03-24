package com.kd.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.RedisPrexConst;
import com.kd.tools.redissync.Sync;


public class SupervisorEntSync implements Sync {
	private static final Logger logger = LoggerFactory.getLogger(SupervisorEntSync.class);

	@Override
	public void doSync() {
		// 企业
		long start = System.currentTimeMillis();

		new EntAbnormalItemSync().doSync();
		new EntBranchSync().doSync();
		new EntChgRecordSync().doSync();
		new EntEquitySync().doSync();
		new EntSoftCopyrightsSync().doSync();
		new EntBasicInfoSync().doSync();
		new EntRelatedSync().doSync();

		newSync();
		new RptEntJudgeValueSync().doSync();



		long end = System.currentTimeMillis();
		logger.info("Sync the ent data total used time: " + (end-start));
	}

	public void newSync(){

		new EntGeneralObjectSync("rds_ent_holder",RedisPrexConst.EntHolderSync).doSync();
		new EntGeneralObjectSync("rds_ent_invest",RedisPrexConst.EntInvestSync).doSync();
		new EntGeneralObjectSync("rds_ent_law",RedisPrexConst.EntLawSync).doSync();
		new EntGeneralObjectSync("rds_ent_mortgages",RedisPrexConst.EntMortgagesSync).doSync();
		new EntGeneralObjectSync("rds_ent_patent",RedisPrexConst.EntPatentSync).doSync();

	}

	@Override
	public void doFullSync() {
		// TODO Auto-generated method stub
		clearData();
		doSync();
	}

	@Override
	public void clearData() {
		new EntAbnormalItemSync().clearData();
		new EntBranchSync().clearData();
		new EntChgRecordSync().clearData();
		new EntEquitySync().clearData();
		new EntSoftCopyrightsSync().clearData();
		new EntBasicInfoSync().clearData();
		new EntRelatedSync().clearData();

		new EntGeneralObjectSync("rds_ent_holder",RedisPrexConst.EntHolderSync).clearData();
		new EntGeneralObjectSync("rds_ent_invest",RedisPrexConst.EntInvestSync).clearData();
		new EntGeneralObjectSync("rds_ent_law",RedisPrexConst.EntLawSync).clearData();
		new EntGeneralObjectSync("rds_ent_mortgages",RedisPrexConst.EntMortgagesSync).clearData();
		new EntGeneralObjectSync("rds_ent_patent",RedisPrexConst.EntPatentSync).clearData();
	}

}
