package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRptOrgOverallTrends<M extends BaseRptOrgOverallTrends<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "rpt_org_overall_trends";

	/**
	 * 时间节点（按月统计）
	 */
	public void setDurTime(java.lang.String durTime) {
		set("dur_time", durTime);
	}

	/**
	 * 时间节点（按月统计）
	 */
	public java.lang.String getDurTime() {
		return get("dur_time");
	}

	/**
	 * 投资事件数量
	 */
	public void setINum(java.lang.Integer iNum) {
		set("i_num", iNum);
	}

	/**
	 * 投资事件数量
	 */
	public java.lang.Integer getINum() {
		return get("i_num");
	}

	/**
	 * 退出事件数量
	 */
	public void setENum(java.lang.Integer eNum) {
		set("e_num", eNum);
	}

	/**
	 * 退出事件数量
	 */
	public java.lang.Integer getENum() {
		return get("e_num");
	}

	/**
	 * 一级市场投资行为的边际利润率
	 */
	public void setPsIbmpa(java.lang.Double psIbmpa) {
		set("ps_ibmpa", psIbmpa);
	}

	/**
	 * 一级市场投资行为的边际利润率
	 */
	public java.lang.Double getPsIbmpa() {
		return get("ps_ibmpa");
	}

}
