package com.kd.model.general.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseStockInfo<M extends BaseStockInfo<M>> extends Model<M> implements IBean {

	/**
	 * 表名
	 */
	public static final String TableName = "stock_info";

	/**
	 * 股票代码
	 */
	public void setStockCode(java.lang.String stockCode) {
		set("stock_code", stockCode);
	}

	/**
	 * 股票代码
	 */
	public java.lang.String getStockCode() {
		return get("stock_code");
	}

	/**
	 * 公司名称
	 */
	public void setCnName(java.lang.String cnName) {
		set("cn_name", cnName);
	}

	/**
	 * 公司名称
	 */
	public java.lang.String getCnName() {
		return get("cn_name");
	}

	/**
	 * 英文名称
	 */
	public void setEnName(java.lang.String enName) {
		set("en_name", enName);
	}

	/**
	 * 英文名称
	 */
	public java.lang.String getEnName() {
		return get("en_name");
	}

	/**
	 * 公司简介
	 */
	public void setCnDesc(java.lang.String cnDesc) {
		set("cn_desc", cnDesc);
	}

	/**
	 * 公司简介
	 */
	public java.lang.String getCnDesc() {
		return get("cn_desc");
	}

	/**
	 * 主营产品
	 */
	public void setMainProduct(java.lang.String mainProduct) {
		set("main_product", mainProduct);
	}

	/**
	 * 主营产品
	 */
	public java.lang.String getMainProduct() {
		return get("main_product");
	}

	/**
	 * 成立日期
	 */
	public void setSetupDate(java.lang.String setupDate) {
		set("setup_date", setupDate);
	}

	/**
	 * 成立日期
	 */
	public java.lang.String getSetupDate() {
		return get("setup_date");
	}

	/**
	 * 上市日期
	 */
	public void setListDate(java.lang.String listDate) {
		set("list_date", listDate);
	}

	/**
	 * 上市日期
	 */
	public java.lang.String getListDate() {
		return get("list_date");
	}

	/**
	 * 工商登记号
	 */
	public void setBizRegNo(java.lang.String bizRegNo) {
		set("biz_reg_no", bizRegNo);
	}

	/**
	 * 工商登记号
	 */
	public java.lang.String getBizRegNo() {
		return get("biz_reg_no");
	}

	/**
	 * 注册资本(元)
	 */
	public void setRegCapital(java.lang.Long regCapital) {
		set("reg_capital", regCapital);
	}

	/**
	 * 注册资本(元)
	 */
	public java.lang.Long getRegCapital() {
		return get("reg_capital");
	}

	/**
	 * 法人代表
	 */
	public void setRepOfAp(java.lang.String repOfAp) {
		set("rep_of_ap", repOfAp);
	}

	/**
	 * 法人代表
	 */
	public java.lang.String getRepOfAp() {
		return get("rep_of_ap");
	}

	/**
	 * 实际控制人
	 */
	public void setActCtrl(java.lang.String actCtrl) {
		set("act_ctrl", actCtrl);
	}

	/**
	 * 实际控制人
	 */
	public java.lang.String getActCtrl() {
		return get("act_ctrl");
	}

	/**
	 * 最终控制方
	 */
	public void setFinalCtrl(java.lang.String finalCtrl) {
		set("final_ctrl", finalCtrl);
	}

	/**
	 * 最终控制方
	 */
	public java.lang.String getFinalCtrl() {
		return get("final_ctrl");
	}

	/**
	 * 所属证监会行业
	 */
	public void setCsrcIndustry(java.lang.String csrcIndustry) {
		set("csrc_industry", csrcIndustry);
	}

	/**
	 * 所属证监会行业
	 */
	public java.lang.String getCsrcIndustry() {
		return get("csrc_industry");
	}

	/**
	 * 员工总数
	 */
	public void setEmployeeNum(java.lang.Long employeeNum) {
		set("employee_num", employeeNum);
	}

	/**
	 * 员工总数
	 */
	public java.lang.Long getEmployeeNum() {
		return get("employee_num");
	}

	/**
	 * 总经理
	 */
	public void setCeo(java.lang.String ceo) {
		set("ceo", ceo);
	}

	/**
	 * 总经理
	 */
	public java.lang.String getCeo() {
		return get("ceo");
	}

	/**
	 * 董事会秘书
	 */
	public void setBoardSecretary(java.lang.String boardSecretary) {
		set("board_secretary", boardSecretary);
	}

	/**
	 * 董事会秘书
	 */
	public java.lang.String getBoardSecretary() {
		return get("board_secretary");
	}

	/**
	 * 省份
	 */
	public void setProv(java.lang.String prov) {
		set("prov", prov);
	}

	/**
	 * 省份
	 */
	public java.lang.String getProv() {
		return get("prov");
	}

	/**
	 * 城市
	 */
	public void setCity(java.lang.String city) {
		set("city", city);
	}

	/**
	 * 城市
	 */
	public java.lang.String getCity() {
		return get("city");
	}

	/**
	 * 注册地址
	 */
	public void setRegAddr(java.lang.String regAddr) {
		set("reg_addr", regAddr);
	}

	/**
	 * 注册地址
	 */
	public java.lang.String getRegAddr() {
		return get("reg_addr");
	}

	/**
	 * 办公地址
	 */
	public void setOfficeAddr(java.lang.String officeAddr) {
		set("office_addr", officeAddr);
	}

	/**
	 * 办公地址
	 */
	public java.lang.String getOfficeAddr() {
		return get("office_addr");
	}

	/**
	 * 邮编
	 */
	public void setPostcode(java.lang.String postcode) {
		set("postcode", postcode);
	}

	/**
	 * 邮编
	 */
	public java.lang.String getPostcode() {
		return get("postcode");
	}

	/**
	 * 电话
	 */
	public void setTel(java.lang.String tel) {
		set("tel", tel);
	}

	/**
	 * 电话
	 */
	public java.lang.String getTel() {
		return get("tel");
	}

	/**
	 * 传真
	 */
	public void setFax(java.lang.String fax) {
		set("fax", fax);
	}

	/**
	 * 传真
	 */
	public java.lang.String getFax() {
		return get("fax");
	}

	/**
	 * 电子邮件
	 */
	public void setEmail(java.lang.String email) {
		set("email", email);
	}

	/**
	 * 电子邮件
	 */
	public java.lang.String getEmail() {
		return get("email");
	}

	/**
	 * 公司网站
	 */
	public void setWebsite(java.lang.String website) {
		set("website", website);
	}

	/**
	 * 公司网站
	 */
	public java.lang.String getWebsite() {
		return get("website");
	}

	/**
	 * 经营范围
	 */
	public void setScopeOfBusiness(java.lang.String scopeOfBusiness) {
		set("scope_of_business", scopeOfBusiness);
	}

	/**
	 * 经营范围
	 */
	public java.lang.String getScopeOfBusiness() {
		return get("scope_of_business");
	}

}
