package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BasePmExitEventDetail<M extends BasePmExitEventDetail<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "pm_exit_event_detail";

	/**
	 * 自增主键
	 */
	public void setEventId(java.lang.Integer eventId) {
		set("event_id", eventId);
	}

	/**
	 * 自增主键
	 */
	public java.lang.Integer getEventId() {
		return get("event_id");
	}

	/**
	 * 事件标题
	 */
	public void setEventTitle(java.lang.String eventTitle) {
		set("event_title", eventTitle);
	}

	/**
	 * 事件标题
	 */
	public java.lang.String getEventTitle() {
		return get("event_title");
	}

	/**
	 * 发生日期
	 */
	public void setHappenDate(java.lang.String happenDate) {
		set("happen_date", happenDate);
	}

	/**
	 * 发生日期
	 */
	public java.lang.String getHappenDate() {
		return get("happen_date");
	}

	/**
	 * 退出类型
	 */
	public void setExitType(java.lang.String exitType) {
		set("exit_type", exitType);
	}

	/**
	 * 退出类型
	 */
	public java.lang.String getExitType() {
		return get("exit_type");
	}

	/**
	 * 事件详情
	 */
	public void setEventDesc(java.lang.String eventDesc) {
		set("event_desc", eventDesc);
	}

	/**
	 * 事件详情
	 */
	public java.lang.String getEventDesc() {
		return get("event_desc");
	}

	/**
	 * 企业名称
	 */
	public void setEntCnName(java.lang.String entCnName) {
		set("ent_cn_name", entCnName);
	}

	/**
	 * 企业名称
	 */
	public java.lang.String getEntCnName() {
		return get("ent_cn_name");
	}

	/**
	 * 企业UUID
	 */
	public void setEntUuid(java.lang.String entUuid) {
		set("ent_uuid", entUuid);
	}

	/**
	 * 企业UUID
	 */
	public java.lang.String getEntUuid() {
		return get("ent_uuid");
	}

	/**
	 * 基金ID (关联 data_source.cv_fund)
	 */
	public void setFundId(java.lang.String fundId) {
		set("fund_id", fundId);
	}

	/**
	 * 基金ID (关联 data_source.cv_fund)
	 */
	public java.lang.String getFundId() {
		return get("fund_id");
	}

	/**
	 * 基金UUID
	 */
	public void setFundUuid(java.lang.String fundUuid) {
		set("fund_uuid", fundUuid);
	}

	/**
	 * 基金UUID
	 */
	public java.lang.String getFundUuid() {
		return get("fund_uuid");
	}

	/**
	 * 基金名称
	 */
	public void setFundName(java.lang.String fundName) {
		set("fund_name", fundName);
	}

	/**
	 * 基金名称
	 */
	public java.lang.String getFundName() {
		return get("fund_name");
	}

	/**
	 * 管理人ID (关联 ops_rdd.ops_org_user_info)
	 */
	public void setUserId(java.lang.String userId) {
		set("user_id", userId);
	}

	/**
	 * 管理人ID (关联 ops_rdd.ops_org_user_info)
	 */
	public java.lang.String getUserId() {
		return get("user_id");
	}

	/**
	 * 管理人
	 */
	public void setUserName(java.lang.String userName) {
		set("user_name", userName);
	}

	/**
	 * 管理人
	 */
	public java.lang.String getUserName() {
		return get("user_name");
	}

	/**
	 * 机构ID (关联 ops_rdd.ops_org_gp_info)
	 */
	public void setOrgId(java.lang.String orgId) {
		set("org_id", orgId);
	}

	/**
	 * 机构ID (关联 ops_rdd.ops_org_gp_info)
	 */
	public java.lang.String getOrgId() {
		return get("org_id");
	}

	/**
	 * 机构全称
	 */
	public void setOrgCnName(java.lang.String orgCnName) {
		set("org_cn_name", orgCnName);
	}

	/**
	 * 机构全称
	 */
	public java.lang.String getOrgCnName() {
		return get("org_cn_name");
	}

	/**
	 * 机构简称
	 */
	public void setOrgCnShort(java.lang.String orgCnShort) {
		set("org_cn_short", orgCnShort);
	}

	/**
	 * 机构简称
	 */
	public java.lang.String getOrgCnShort() {
		return get("org_cn_short");
	}

	/**
	 * 回报总金额（万美元）
	 */
	public void setAmount(java.lang.Double amount) {
		set("amount", amount);
	}

	/**
	 * 回报总金额（万美元）
	 */
	public java.lang.Double getAmount() {
		return get("amount");
	}

	/**
	 * 退出时持股比例
	 */
	public void setStockRight(java.lang.Double stockRight) {
		set("stock_right", stockRight);
	}

	/**
	 * 退出时持股比例
	 */
	public java.lang.Double getStockRight() {
		return get("stock_right");
	}

	/**
	 * 初次投资时间
	 */
	public void setFirstInvestDate(java.lang.String firstInvestDate) {
		set("first_invest_date", firstInvestDate);
	}

	/**
	 * 初次投资时间
	 */
	public java.lang.String getFirstInvestDate() {
		return get("first_invest_date");
	}

	/**
	 * 投资总金额（万美元）
	 */
	public void setTotalInvest(java.lang.Double totalInvest) {
		set("total_invest", totalInvest);
	}

	/**
	 * 投资总金额（万美元）
	 */
	public java.lang.Double getTotalInvest() {
		return get("total_invest");
	}

	/**
	 * 账面回报率
	 */
	public void setBringRate(java.lang.Double bringRate) {
		set("bring_rate", bringRate);
	}

	/**
	 * 账面回报率
	 */
	public java.lang.Double getBringRate() {
		return get("bring_rate");
	}

	/**
	 * 账面IRR
	 */
	public void setIrr(java.lang.Double irr) {
		set("irr", irr);
	}

	/**
	 * 账面IRR
	 */
	public java.lang.Double getIrr() {
		return get("irr");
	}

}