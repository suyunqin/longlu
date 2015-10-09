package com.jboa.entity;

import java.util.Date;

/**
 * ClaimVoucherStatics entity. @author MyEclipse Persistence Tools
 */

public class ClaimVoucherStatics implements java.io.Serializable {

	// Fields

	private Long id;
	private Long department_id;
	private Double totalCount;
	private Short year;
	private Byte month;
	private Date modifyTime;

	// Constructors

	/** default constructor */
	public ClaimVoucherStatics() {
	}

	/** full constructor */
	public ClaimVoucherStatics(Long id, Long department_id, Double totalCount,
			Short year, Byte month, Date modifyTime) {
		super();
		this.id = id;
		this.department_id = department_id;
		this.totalCount = totalCount;
		this.year = year;
		this.month = month;
		this.modifyTime = modifyTime;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public Double getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(Double totalCount) {
		this.totalCount = totalCount;
	}

	public Short getYear() {
		return this.year;
	}

	public void setYear(Short year) {
		this.year = year;
	}

	public Byte getMonth() {
		return this.month;
	}

	public void setMonth(Byte month) {
		this.month = month;
	}

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}