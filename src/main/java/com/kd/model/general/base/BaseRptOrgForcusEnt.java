package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRptOrgForcusEnt<M extends BaseRptOrgForcusEnt<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "rpt_org_forcus_ent";

	/**
	 * 企业编码
	 */
	public void setOrgId(java.lang.Integer orgId) {
		set("org_id", orgId);
	}

	/**
	 * 企业编码
	 */
	public java.lang.Integer getOrgId() {
		return get("org_id");
	}

	/**
	 * 关注企业的名称
	 */
	public void setEntCnName(java.lang.String entCnName) {
		set("ent_cn_name", entCnName);
	}

	/**
	 * 关注企业的名称
	 */
	public java.lang.String getEntCnName() {
		return get("ent_cn_name");
	}

	/**
	 * 关注企业的UUID
	 */
	public void setEntUuid(java.lang.String entUuid) {
		set("ent_uuid", entUuid);
	}

	/**
	 * 关注企业的UUID
	 */
	public java.lang.String getEntUuid() {
		return get("ent_uuid");
	}

	/**
	 * 最后关注日期
	 */
	public void setHappenDate(java.lang.String happenDate) {
		set("happen_date", happenDate);
	}

	/**
	 * 最后关注日期
	 */
	public java.lang.String getHappenDate() {
		return get("happen_date");
	}

}
