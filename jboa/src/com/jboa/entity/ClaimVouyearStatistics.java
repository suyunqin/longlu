package com.jboa.entity;

import java.util.Date;

/**
 * ClaimVouyearStatistics entity. @author MyEclipse Persistence Tools
 */

public class ClaimVouyearStatistics implements java.io.Serializable {

	// Fields

	private Long id;
	private Double totalCount;
	private Short year;
	private Date modifyTime;
	private Long departmentId;

	// Constructors

	/** default constructor */
	public ClaimVouyearStatistics() {
	}

	/** full constructor */
	public ClaimVouyearStatistics(Double totalCount, Short year,
			Date modifyTime, Long departmentId) {
		this.totalCount = totalCount;
		this.year = year;
		this.modifyTime = modifyTime;
		this.departmentId = departmentId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}