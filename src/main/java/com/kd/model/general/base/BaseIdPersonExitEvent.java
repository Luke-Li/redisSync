package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseIdPersonExitEvent<M extends BaseIdPersonExitEvent<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "id_person_exit_event";

	/**
	 * 管理人ID
	 */
	public void setUserId(java.lang.Integer userId) {
		set("user_id", userId);
	}

	/**
	 * 管理人ID
	 */
	public java.lang.Integer getUserId() {
		return get("user_id");
	}

	/**
	 * 退出事件ID，关联dw_basic_data.ops_exit_event_detail的event_id
	 */
	public void setEventId(java.lang.Integer eventId) {
		set("event_id", eventId);
	}

	/**
	 * 退出事件ID，关联dw_basic_data.ops_exit_event_detail的event_id
	 */
	public java.lang.Integer getEventId() {
		return get("event_id");
	}

}