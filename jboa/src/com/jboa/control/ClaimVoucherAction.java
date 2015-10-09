package com.jboa.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;

import com.jboa.dao.ClaimVoucherDAO;
import com.jboa.entity.ClaimVoucher;
import com.jboa.entity.Employee;
import com.jboa.util.ClaimVoucherUtil;
import com.opensymphony.xwork2.ActionSupport;

public class ClaimVoucherAction extends ActionSupport implements SessionAware {
	private ClaimVoucherDAO claimVoucherDAO;
	private String rows;// 每页显示的记录数
	private String page;// 当前第几页
	private Map<String, Object> session = new HashMap<String, Object>();
	private JSONObject jsonResult;
	private String loginInfo;
	private Long claimID;
	private Boolean booleanResult;

	public String findByPage() {

		if (session.get("user") == null) {
			loginInfo = "noLogin";
			return INPUT;
		}

		int page = Integer
				.valueOf((this.page == null || this.page == "0") ? "1"
						: this.page);

		int rows = Integer
				.valueOf((this.rows == null || this.rows == "0") ? "10"
						: this.rows);
		Map<String, Object> jsonMap = new HashMap<String, Object>();// 定义map

		Long count = this.claimVoucherDAO
				.getClaimVoucherCountBySn(((Employee) this.session.get("user"))
						.getSn());

		List<ClaimVoucherUtil> list = this.claimVoucherDAO.findByPage(page,
				rows, ((Employee) this.session.get("user")).getSn());

		jsonMap.put("total", count);
		jsonMap.put("rows", list);

		jsonResult = JSONObject.fromObject(jsonMap);

		return SUCCESS;
	}

	public String findById() {
		ClaimVoucher temp = claimVoucherDAO.findById(claimID);

		this.session.put("claim", temp);
		booleanResult = true;
		return SUCCESS;
	}

	public String clearClaimInfo() {
		session.remove("claim");
		booleanResult = true;
		return SUCCESS;
	}

	public void setClaimVoucherDAO(ClaimVoucherDAO claimVoucherDAO) {
		this.claimVoucherDAO = claimVoucherDAO;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public JSONObject getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(JSONObject jsonResult) {
		this.jsonResult = jsonResult;
	}

	public String getLoginInfo() {
		return loginInfo;
	}

	public void setLoginInfo(String loginInfo) {
		this.loginInfo = loginInfo;
	}

	public Long getClaimID() {
		return claimID;
	}

	public void setClaimID(Long claimID) {
		this.claimID = claimID;
	}

	public Boolean getBooleanResult() {
		return booleanResult;
	}

	public void setBooleanResult(Boolean booleanResult) {
		this.booleanResult = booleanResult;
	}

}
