package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDailyEvent75<M extends BaseDailyEvent75<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "daily_event_75";

	/**
	 * 自增ID
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	/**
	 * 自增ID
	 */
	public java.lang.Integer getId() {
		return get("id");
	}

	/**
	 * 事件ID
	 */
	public void setEventId(java.lang.Integer eventId) {
		set("event_id", eventId);
	}

	/**
	 * 事件ID
	 */
	public java.lang.Integer getEventId() {
		return get("event_id");
	}

	/**
	 * 事件种类；invest/exit
	 */
	public void setEventClass(java.lang.String eventClass) {
		set("event_class", eventClass);
	}

	/**
	 * 事件种类；invest/exit
	 */
	public java.lang.String getEventClass() {
		return get("event_class");
	}

	/**
	 * 事件类型
	 */
	public void setEventType(java.lang.String eventType) {
		set("event_type", eventType);
	}

	/**
	 * 事件类型
	 */
	public java.lang.String getEventType() {
		return get("event_type");
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
	 * 发生时间
	 */
	public void setHappenDate(java.lang.String happenDate) {
		set("happen_date", happenDate);
	}

	/**
	 * 发生时间
	 */
	public java.lang.String getHappenDate() {
		return get("happen_date");
	}

	/**
	 * 事件描述
	 */
	public void setEventDesc(java.lang.String eventDesc) {
		set("event_desc", eventDesc);
	}

	/**
	 * 事件描述
	 */
	public java.lang.String getEventDesc() {
		return get("event_desc");
	}

	/**
	 * 企业
	 */
	public void setEntCnName(java.lang.String entCnName) {
		set("ent_cn_name", entCnName);
	}

	/**
	 * 企业
	 */
	public java.lang.String getEntCnName() {
		return get("ent_cn_name");
	}

	/**
	 * 基金
	 */
	public void setFundName(java.lang.String fundName) {
		set("fund_name", fundName);
	}

	/**
	 * 基金
	 */
	public java.lang.String getFundName() {
		return get("fund_name");
	}

	/**
	 * 机构
	 */
	public void setOrgCnName(java.lang.String orgCnName) {
		set("org_cn_name", orgCnName);
	}

	/**
	 * 机构
	 */
	public java.lang.String getOrgCnName() {
		return get("org_cn_name");
	}

	/**
	 * 投资总金额（万美元）
	 */
	public void setAmount(java.lang.Double amount) {
		set("amount", amount);
	}

	/**
	 * 投资总金额（万美元）
	 */
	public java.lang.Double getAmount() {
		return get("amount");
	}

	/**
	 * 持股比例
	 */
	public void setStockRight(java.lang.Double stockRight) {
		set("stock_right", stockRight);
	}

	/**
	 * 持股比例
	 */
	public java.lang.Double getStockRight() {
		return get("stock_right");
	}

	/**
	 * 对应exit事件 --第一次发生时间
	 */
	public void setFirstInvestDate(java.lang.String firstInvestDate) {
		set("first_invest_date", firstInvestDate);
	}

	/**
	 * 对应exit事件 --第一次发生时间
	 */
	public java.lang.String getFirstInvestDate() {
		return get("first_invest_date");
	}

	/**
	 * 对应exit-总投资
	 */
	public void setTotalInvest(java.lang.String totalInvest) {
		set("total_invest", totalInvest);
	}

	/**
	 * 对应exit-总投资
	 */
	public java.lang.String getTotalInvest() {
		return get("total_invest");
	}

	/**
	 * 对应exit-bring_rate
	 */
	public void setBringRate(java.lang.String bringRate) {
		set("bring_rate", bringRate);
	}

	/**
	 * 对应exit-bring_rate
	 */
	public java.lang.String getBringRate() {
		return get("bring_rate");
	}

	/**
	 * 对应exit-irr
	 */
	public void setIrr(java.lang.String irr) {
		set("irr", irr);
	}

	/**
	 * 对应exit-irr
	 */
	public java.lang.String getIrr() {
		return get("irr");
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(java.util.Date createTime) {
		set("create_time", createTime);
	}

	/**
	 * 创建时间
	 */
	public java.util.Date getCreateTime() {
		return get("create_time");
	}

	/**
	 * 更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		set("update_time", updateTime);
	}

	/**
	 * 更新时间
	 */
	public java.util.Date getUpdateTime() {
		return get("update_time");
	}

}