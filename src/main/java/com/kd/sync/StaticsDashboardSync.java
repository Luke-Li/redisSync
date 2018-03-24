package com.kd.sync;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kd.consts.GeneralConst;
import com.kd.model.general.StatDashboard;
import com.kd.tools.redissync.Sync;
import com.kd.utils.SyncMysqlHelper;
import com.kd.utils.TimeUtil;

public class StaticsDashboardSync implements Sync {
	private static final Logger logger = LoggerFactory.getLogger(StaticsDashboardSync.class);

	private static final String static_media = "情报";
	private static final String static_ent = "企业";
	private static final String static_report = "报告";
	private static final String ops_startups = "项目";

	public class StatResult{
		private int total;
		private int daily;
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public int getDaily() {
			return daily;
		}
		public void setDaily(int daily) {
			this.daily = daily;
		}

		public void add(StatResult add){
			if(add != null){
				total += add.getTotal();
				daily += add.getDaily();
			}
		}

	}

	@Override
	public void doSync() {
		logger.info("start to sync Statics!!");

		StatResult statMedia = syncStatTotal(GeneralConst.ops_rdd,"ops_monitor_media_index");
		StatResult statEnt = syncStatTotal(GeneralConst.qxb,"qxb_ent_info");
		StatResult statType = syncStatTotal(GeneralConst.datasource,"choice_report_type");
		StatResult statBasic = syncStatTotal(GeneralConst.datasource,"choice_report_basic");
		StatResult statProject = syncStatTotal(GeneralConst.ops_rdd,"ops_startups_info");

		updateStatTotal(static_media,statMedia);
		updateStatTotal(static_ent,statEnt);
		updateStatTotal(ops_startups,statProject);

		if(statType == null){
			statType = new StatResult();
		}
		statType.add(statBasic);
		updateStatTotal(static_report,statType);

		logger.info("finish to sync statistics info!!");

	}

	@Override
	public void doFullSync() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearData() {
		// TODO Auto-generated method stub

	}

	/**
	 * 统计当日数量和总量
	 * @param syncTime
	 * @param DB
	 * @param table
	 * @return
	 */
	public StatResult syncStatTotal(String DB,String table){

		StatResult stat = new StatResult();

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String statTime = df.format(new Date());

		String sqlUpdate = String.format(
				"select a.total,b.daily from "
				+ " (select '1' as id, count(*) as total from %s) a"
				+ " left join "
				+ " (select '1' as id, count(*) as daily from %s "
				+ " where create_time>'%s') b "
				+ " on a.id=b.id",
				table,table,statTime);

		if("ops_startups_info".equalsIgnoreCase(table)){
			sqlUpdate = String.format(
					"select a.total,b.daily from "
					+ " (select '1' as id, count(*) as total from %s) a"
					+ " left join "
					+ " (select '1' as id, count(*) as daily from %s "
					+ " where createTime>'%s') b "
					+ " on a.id=b.id",
					table,table,statTime);
		}

		ResultSet rsUpdate = null;

		try {
			long start = System.currentTimeMillis();
			rsUpdate = SyncMysqlHelper.getInstance(DB).getResultSet(sqlUpdate);
			long end = System.currentTimeMillis();
			logger.info("load all info from db cost time:"+(end-start));
			if(rsUpdate.next()) {
				 stat.setTotal(rsUpdate.getInt("total"));
				 stat.setDaily(rsUpdate.getInt("daily"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("", ex);
		} finally {
			SyncMysqlHelper.getInstance(DB).close(rsUpdate);
		}

		return stat;
	}

	/**
	 *
	 * 统计当日数量
	 * @param DB
	 * @param table
	 */
	public int syncStat(String DB,String table){

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String statTime = df.format(new Date());

		String sqlUpdate = String.format(
				"select count(*) as number from %s where create_time>'%s'",
				table,statTime);

		if("ops_startups_info".equalsIgnoreCase(table)){
			sqlUpdate = String.format(
					"select count(*) as number from %s where createTime>'%s'",
					table,statTime);
		}

		ResultSet rsUpdate = null;
		int num = 0;

		try {
			long start = System.currentTimeMillis();
			rsUpdate = SyncMysqlHelper.getInstance(DB).getResultSet(sqlUpdate);
			long end = System.currentTimeMillis();
			logger.info("load all info from db cost time:"+(end-start));
			if(rsUpdate.next()) {
				num = rsUpdate.getInt("number");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error("", ex);
		} finally {
			SyncMysqlHelper.getInstance(DB).close(rsUpdate);
		}
		return num;
	}

	/**
	 * 更新数量
	 * @param name
	 * @param num
	 */
	public void updateStat(String name, int num){
		try{
			String date = TimeUtil.getCurrentDay();
			String sql = String.format("select * from %s where name=? and count_date=?",StatDashboard.TableName);

			StatDashboard item = StatDashboard.dao.findFirst(sql, name, date);

			if(item == null){
				item = new StatDashboard();
				item.setName(name);
				item.setCountDate(date);
			}

			item.setDailyCount(num);

			if(null == item.getId()){
				item.save();
			}else{
				item.update();
			}

		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

	/**
	 * 更新当日量和总量
	 * @param name
	 * @param num
	 */
	public void updateStatTotal(String name, StatResult stat){
		try{
			if(stat == null){
				return;
			}
			String date = TimeUtil.getCurrentDay();
			String sql = String.format("select * from %s where name=? and count_date=?",StatDashboard.TableName);

			StatDashboard item = StatDashboard.dao.findFirst(sql, name, date);

			if(item == null){
				item = new StatDashboard();
				item.setName(name);
				item.setCountDate(date);
			}

			item.setDailyCount(stat.getDaily());
			item.setTotal(stat.getTotal());

			if(null == item.getId()){
				item.save();
			}else{
				item.update();
			}

		}catch(Exception e){
			logger.error(e.getMessage());
		}
	}

}
