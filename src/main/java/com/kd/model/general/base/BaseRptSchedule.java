package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRptSchedule<M extends BaseRptSchedule<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "rpt_schedule";

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
	 * 日期
	 */
	public void setTime(java.util.Date time) {
		set("time", time);
	}

	/**
	 * 日期
	 */
	public java.util.Date getTime() {
		return get("time");
	}

	/**
	 * 日程名称
	 */
	public void setName(java.lang.String name) {
		set("name", name);
	}

	/**
	 * 日程名称
	 */
	public java.lang.String getName() {
		return get("name");
	}

	/**
	 * 日程类型（研讨会、峰会、定制活动）
	 */
	public void setType(java.lang.String type) {
		set("type", type);
	}

	/**
	 * 日程类型（研讨会、峰会、定制活动）
	 */
	public java.lang.String getType() {
		return get("type");
	}

	/**
	 * 所属行业（对应 id_category）
	 */
	public void setCategory(java.lang.String category) {
		set("category", category);
	}

	/**
	 * 所属行业（对应 id_category）
	 */
	public java.lang.String getCategory() {
		return get("category");
	}

	/**
	 * 机构简称
	 */
	public void setOrgCnShort(java.lang.String orgCnShort) {
		set("orgCnShort", orgCnShort);
	}

	/**
	 * 机构简称
	 */
	public java.lang.String getOrgCnShort() {
		return get("orgCnShort");
	}

	/**
	 * 地域
	 */
	public void setGeo(java.lang.String geo) {
		set("geo", geo);
	}

	/**
	 * 地域
	 */
	public java.lang.String getGeo() {
		return get("geo");
	}

	/**
	 * 链接地址
	 */
	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	/**
	 * 链接地址
	 */
	public java.lang.String getUrl() {
		return get("url");
	}

	/**
	 * 日程明细
	 */
	public void setComment(java.lang.String comment) {
		set("comment", comment);
	}

	/**
	 * 日程明细
	 */
	public java.lang.String getComment() {
		return get("comment");
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
