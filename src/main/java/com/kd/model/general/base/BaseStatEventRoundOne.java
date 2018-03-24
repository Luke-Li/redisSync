package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseStatEventRoundOne<M extends BaseStatEventRoundOne<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "stat_event_round_one";

	/**
	 * 轮次ID
	 */
	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	/**
	 * 轮次ID
	 */
	public java.lang.Integer getId() {
		return get("id");
	}

	/**
	 * 早期投资
	 */
	public void setInvestEarly(java.lang.Integer investEarly) {
		set("invest_early", investEarly);
	}

	/**
	 * 早期投资
	 */
	public java.lang.Integer getInvestEarly() {
		return get("invest_early");
	}

	/**
	 * 中期投资
	 */
	public void setInvestMiddle(java.lang.Integer investMiddle) {
		set("invest_middle", investMiddle);
	}

	/**
	 * 中期投资
	 */
	public java.lang.Integer getInvestMiddle() {
		return get("invest_middle");
	}

	/**
	 * 后期投资
	 */
	public void setInvestLate(java.lang.Integer investLate) {
		set("invest_late", investLate);
	}

	/**
	 * 后期投资
	 */
	public java.lang.Integer getInvestLate() {
		return get("invest_late");
	}

	/**
	 * 其他投资
	 */
	public void setInvestOther(java.lang.Integer investOther) {
		set("invest_other", investOther);
	}

	/**
	 * 其他投资
	 */
	public java.lang.Integer getInvestOther() {
		return get("invest_other");
	}

	/**
	 * 一级市场退出
	 */
	public void setExitOne(java.lang.Integer exitOne) {
		set("exit_one", exitOne);
	}

	/**
	 * 一级市场退出
	 */
	public java.lang.Integer getExitOne() {
		return get("exit_one");
	}

	/**
	 * 二级市场退出
	 */
	public void setExitTwo(java.lang.Integer exitTwo) {
		set("exit_two", exitTwo);
	}

	/**
	 * 二级市场退出
	 */
	public java.lang.Integer getExitTwo() {
		return get("exit_two");
	}

	/**
	 * 统计时间
	 */
	public void setCountDate(java.lang.String countDate) {
		set("count_date", countDate);
	}

	/**
	 * 统计时间
	 */
	public java.lang.String getCountDate() {
		return get("count_date");
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