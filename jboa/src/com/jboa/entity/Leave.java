package com.jboa.entity;

import java.util.Date;

/**
 * Leave entity. @author MyEclipse Persistence Tools
 */

public class Leave implements java.io.Serializable {

	// Fields

	private Long id;
	private String employeeSn;
	private Date starttime;
	private Date endtime;
	private Double leaveday;
	private String reason;
	private String status;
	private String leavetype;
	private String nextDealSn;
	private String approveOpinion;
	private Date createtime;
	private Date modifytime;

	// Constructors

	/** default constructor */
	public Leave() {
	}

	/** minimal constructor */
	public Leave(String employeeSn, Date starttime, Date endtime,
			Double leaveday, String reason) {
		this.employeeSn = employeeSn;
		this.starttime = starttime;
		this.endtime = endtime;
		this.leaveday = leaveday;
		this.reason = reason;
	}

	/** full constructor */
	public Leave(String employeeSn, Date starttime, Date endtime,
			Double leaveday, String reason, String status, String leavetype,
			String nextDealSn, String approveOpinion, Date createtime,
			Date modifytime) {
		this.employeeSn = employeeSn;
		this.starttime = starttime;
		this.endtime = endtime;
		this.leaveday = leaveday;
		this.reason = reason;
		this.status = status;
		this.leavetype = leavetype;
		this.nextDealSn = nextDealSn;
		this.approveOpinion = approveOpinion;
		this.createtime = createtime;
		this.modifytime = modifytime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployeeSn() {
		return this.employeeSn;
	}

	public void setEmployeeSn(String employeeSn) {
		this.employeeSn = employeeSn;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Double getLeaveday() {
		return this.leaveday;
	}

	public void setLeaveday(Double leaveday) {
		this.leaveday = leaveday;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLeavetype() {
		return this.leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}

	public String getNextDealSn() {
		return this.nextDealSn;
	}

	public void setNextDealSn(String nextDealSn) {
		this.nextDealSn = nextDealSn;
	}

	public String getApproveOpinion() {
		return this.approveOpinion;
	}

	public void setApproveOpinion(String approveOpinion) {
		this.approveOpinion = approveOpinion;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return this.modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}