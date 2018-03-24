package com.kd.utils;

import java.util.ArrayList;
import java.util.List;

import com.kd.consts.RedisPrexConst;
import com.kd.model.general.EntAbnormalItem;
import com.kd.model.general.EntBasicInfo;
import com.kd.model.general.EntBranch;
import com.kd.model.general.EntChgRecord;
import com.kd.model.general.EntEquity;
import com.kd.model.general.EntIndustry;
import com.kd.model.general.EntRelated;
import com.kd.model.general.EntSoftCopyrights;
import com.kd.model.general.StockFeatureAll;
import com.kd.model.general.StockFeatureAllScaled;
import com.kd.model.general.StockFeatureParameter;
import com.kd.model.general.StockFinanceChart;
import com.kd.model.general.StockHolderLatest;
import com.kd.model.general.StockInfo;
import com.kd.model.general.StockInstInvest;
import com.kd.model.general.StockListPotentialMa;
import com.kd.model.general.StockManageTeam;

public class RedisJfinalModel {

	public static EntBasicInfo getEntBasicInfo(String id){
		String key = String.format("%s%s%s", RedisPrexConst.EntBasicInfoSync, RedisPrexConst.SEPARATOR, id);
		return JedisObjectUtil.getData(EntBasicInfo.class,key);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<EntBranch> getEntBranchFromList(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntBranchSync, RedisPrexConst.SEPARATOR, uuid);
		return (ArrayList<EntBranch>)JedisObjectUtil.getData(List.class, key);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<EntAbnormalItem> getEntAbnormalItemFromList(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntAbnormalItemSync, RedisPrexConst.SEPARATOR, uuid);
		return (ArrayList<EntAbnormalItem>)JedisObjectUtil.getData(List.class, key);
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<EntChgRecord> getEntChgRecordFromList(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntChgRecordSync, RedisPrexConst.SEPARATOR, uuid);
		return (ArrayList<EntChgRecord>)JedisObjectUtil.getData(List.class, key);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<EntEquity> getEntEquityFromList(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntEquitySync, RedisPrexConst.SEPARATOR, uuid);
		return (ArrayList<EntEquity>)JedisObjectUtil.getData(List.class, key);
	}


	public static EntIndustry getEntIndustry(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntIndustrySync, RedisPrexConst.SEPARATOR, uuid);
		EntIndustry tmp = JedisObjectUtil.getData(EntIndustry.class, key);
		return tmp;
	}


	@SuppressWarnings("unchecked")
	public static ArrayList<EntSoftCopyrights> getEntSoftCopyrightsFromList(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntSoftCopyrightsSync, RedisPrexConst.SEPARATOR, uuid);
		return (ArrayList<EntSoftCopyrights>)JedisObjectUtil.getData(List.class, key);
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<EntRelated> getEntRelated(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.EntRelatedSync, RedisPrexConst.SEPARATOR, uuid);
		return (ArrayList<EntRelated>)JedisObjectUtil.getData(List.class, key);
	}


	//this part is for stock

	public static StockFeatureAll getStockFeatureAll(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockFeatureAllSync, RedisPrexConst.SEPARATOR, uuid);
		StockFeatureAll tmp = JedisObjectUtil.getData(StockFeatureAll.class, key);
		return tmp;
	}


	public static StockListPotentialMa getStockListPotentialMa(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockListPotentialMaSync, RedisPrexConst.SEPARATOR, uuid);
		StockListPotentialMa tmp = JedisObjectUtil.getData(StockListPotentialMa.class, key);
		return tmp;
	}
	public static StockFeatureAllScaled getStockFeatureAllScaled(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockFeatureAllScaledSync, RedisPrexConst.SEPARATOR, uuid);
		StockFeatureAllScaled tmp = JedisObjectUtil.getData(StockFeatureAllScaled.class, key);
		return tmp;
	}
	public static StockFeatureParameter getStockFeatureParameter(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockFeatureParameterSync, RedisPrexConst.SEPARATOR, uuid);
		StockFeatureParameter tmp = JedisObjectUtil.getData(StockFeatureParameter.class, key);
		return tmp;
	}
	public static StockFinanceChart getStockFinanceChart(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockFinanceChartSync, RedisPrexConst.SEPARATOR, uuid);
		StockFinanceChart tmp = JedisObjectUtil.getData(StockFinanceChart.class, key);
		return tmp;
	}
	public static StockInfo getStockInfo(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockInfoSync, RedisPrexConst.SEPARATOR, uuid);
		StockInfo tmp = JedisObjectUtil.getData(StockInfo.class, key);
		return tmp;
	}

	public static StockHolderLatest getStockHolderLatest(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockHolderLatestSync, RedisPrexConst.SEPARATOR, uuid);
		StockHolderLatest tmp = JedisObjectUtil.getData(StockHolderLatest.class, key);
		return tmp;
	}
	public static StockInstInvest getStockInstInvest(String uuid){
		String key = String.format("%s%s%s", RedisPrexConst.StockInstInvestSync, RedisPrexConst.SEPARATOR, uuid);
		StockInstInvest tmp = JedisObjectUtil.getData(StockInstInvest.class, key);
		return tmp;
	}
	public static StockManageTeam getStockManageTeam(String code){
		String key = String.format("%s%s%s", RedisPrexConst.StockManageTeamSync, RedisPrexConst.SEPARATOR, code);
		StockManageTeam tmp = JedisObjectUtil.getData(StockManageTeam.class, key);
		return tmp;
	}

}
