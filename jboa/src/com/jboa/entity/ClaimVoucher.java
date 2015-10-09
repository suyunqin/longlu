package com.jboa.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ClaimVoucher entity. @author MyEclipse Persistence Tools
 */

public class ClaimVoucher implements java.io.Serializable {

	// Fields

	private Long id;
	private String NextDealSn;
	private String CreateSn;
	private Date createTime;
	private String event;
	private Double totalAccount;
	private String status;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public ClaimVoucher() {
	}

	/** full constructor */
	public ClaimVoucher(Long id, String nextDealSn, String createSn,
			Date createTime, String event, Double totalAccount, String status,
			Date modifyTime) {
		super();
		this.id = id;
		NextDealSn = nextDealSn;
		CreateSn = createSn;
		this.createTime = createTime;
		this.event = event;
		this.totalAccount = totalAccount;
		this.status = status;
		this.modifyTime = modifyTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNextDealSn() {
		return NextDealSn;
	}

	public void setNextDealSn(String nextDealSn) {
		NextDealSn = nextDealSn;
	}

	public String getCreateSn() {
		return CreateSn;
	}

	public void setCreateSn(String createSn) {
		CreateSn = createSn;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public Double getTotalAccount() {
		return this.totalAccount;
	}

	public void setTotalAccount(Double totalAccount) {
		this.totalAccount = totalAccount;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}