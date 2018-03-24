package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRptEntJudgeValue<M extends BaseRptEntJudgeValue<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "rpt_ent_judge_value";

	/**
	 * 企业编码
	 */
	public void setUuid(java.lang.String uuid) {
		set("uuid", uuid);
	}

	/**
	 * 企业编码
	 */
	public java.lang.String getUuid() {
		return get("uuid");
	}

	/**
	 * basic_score, 基础评分
	 */
	public void setBs(java.lang.Double bs) {
		set("bs", bs);
	}

	/**
	 * basic_score, 基础评分
	 */
	public java.lang.Double getBs() {
		return get("bs");
	}

	/**
	 * tech_score, 技术壁垒
	 */
	public void setTs(java.lang.Double ts) {
		set("ts", ts);
	}

	/**
	 * tech_score, 技术壁垒
	 */
	public java.lang.Double getTs() {
		return get("ts");
	}

	/**
	 * credit_score, 信用评分
	 */
	public void setCrds(java.lang.Double crds) {
		set("crds", crds);
	}

	/**
	 * credit_score, 信用评分
	 */
	public java.lang.Double getCrds() {
		return get("crds");
	}

	/**
	 * capital_score, 资本运作评分
	 */
	public void setCaps(java.lang.Double caps) {
		set("caps", caps);
	}

	/**
	 * capital_score, 资本运作评分
	 */
	public java.lang.Double getCaps() {
		return get("caps");
	}

	/**
	 * stable_score, 运营评分
	 */
	public void setSs(java.lang.Double ss) {
		set("ss", ss);
	}

	/**
	 * stable_score, 运营评分
	 */
	public java.lang.Double getSs() {
		return get("ss");
	}

	/**
	 * basic_score, 基础评分 - 均值
	 */
	public void setAvgBs(java.lang.Double avgBs) {
		set("avg_bs", avgBs);
	}

	/**
	 * basic_score, 基础评分 - 均值
	 */
	public java.lang.Double getAvgBs() {
		return get("avg_bs");
	}

	/**
	 * tech_score, 技术壁垒 - 均值
	 */
	public void setAvgTs(java.lang.Double avgTs) {
		set("avg_ts", avgTs);
	}

	/**
	 * tech_score, 技术壁垒 - 均值
	 */
	public java.lang.Double getAvgTs() {
		return get("avg_ts");
	}

	/**
	 * credit_score, 信用评分 - 均值
	 */
	public void setAvgCrds(java.lang.Double avgCrds) {
		set("avg_crds", avgCrds);
	}

	/**
	 * credit_score, 信用评分 - 均值
	 */
	public java.lang.Double getAvgCrds() {
		return get("avg_crds");
	}

	/**
	 * capital_score, 资本运作评分 - 均值
	 */
	public void setAvgCaps(java.lang.Double avgCaps) {
		set("avg_caps", avgCaps);
	}

	/**
	 * capital_score, 资本运作评分 - 均值
	 */
	public java.lang.Double getAvgCaps() {
		return get("avg_caps");
	}

	/**
	 * stable_score, 运营评分 - 均值
	 */
	public void setAvgSs(java.lang.Double avgSs) {
		set("avg_ss", avgSs);
	}

	/**
	 * stable_score, 运营评分 - 均值
	 */
	public java.lang.Double getAvgSs() {
		return get("avg_ss");
	}

}
