package com.kd.sync;

import com.kd.tools.redissync.Sync;

public class SupervisorStockSync implements Sync {

	@Override
	public void doSync() {
		// stock

		new StockEquityctrlSync().doSync();
		new StockInfoSync().doSync();
		new StockManageTeamSync().doSync();
		new StockFinanceChartSync().doSync();
		new StockHolderLatestSync().doSync();
	}

	@Override
	public void doFullSync() {
		clearData();
		doSync();

	}

	@Override
	public void clearData() {

		new StockEquityctrlSync().clearData();
		new StockInfoSync().clearData();
		new StockManageTeamSync().clearData();
		new StockFinanceChartSync().clearData();
		new StockHolderLatestSync().clearData();
	}

}
