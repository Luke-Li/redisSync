package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseEntInvest<M extends BaseEntInvest<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "ent_invest";

	/**
	 * 企业UUID
	 */
	public void setUuid(java.lang.String uuid) {
		set("uuid", uuid);
	}

	/**
	 * 企业UUID
	 */
	public java.lang.String getUuid() {
		return get("uuid");
	}

	/**
	 * 投资企业名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}

	/**
	 * 投资企业名称
	 */
	public java.lang.String getName() {
		return get("name");
	}

	/**
	 * 投资企业UUID
	 */
	public void setIUuid(java.lang.String iUuid) {
		set("i_uuid", iUuid);
	}

	/**
	 * 投资企业UUID
	 */
	public java.lang.String getIUuid() {
		return get("i_uuid");
	}

	/**
	 * 投资企业成立日期
	 */
	public void setSDate(java.lang.String sDate) {
		set("s_date", sDate);
	}

	/**
	 * 投资企业成立日期
	 */
	public java.lang.String getSDate() {
		return get("s_date");
	}

	/**
	 * 投资企业法定代表人
	 */
	public void setLegal(java.lang.String legal) {
		set("legal", legal);
	}

	/**
	 * 投资企业法定代表人
	 */
	public java.lang.String getLegal() {
		return get("legal");
	}

}