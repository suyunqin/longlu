package com.jboa.entity;

import java.util.Date;

/**
 * CheckResult entity. @author MyEclipse Persistence Tools
 */

public class CheckResult implements java.io.Serializable {

	// Fields

	private Long id;
	private Long claim_id;
	private Date checkTime;
	private String checkerSn;
	private String result;
	private String comm;

	// Constructors

	/** default constructor */
	public CheckResult() {
	}

	/** full constructor */
	public CheckResult(Long id, Long claim_id, Date checkTime,
			String checkerSn, String result, String comm) {
		super();
		this.id = id;
		this.claim_id = claim_id;
		this.checkTime = checkTime;
		this.checkerSn = checkerSn;
		this.result = result;
		this.comm = comm;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClaim_id() {
		return claim_id;
	}

	public void setClaim_id(Long claim_id) {
		this.claim_id = claim_id;
	}

	public Date getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckerSn() {
		return this.checkerSn;
	}

	public void setCheckerSn(String checkerSn) {
		this.checkerSn = checkerSn;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}