package com.jboa.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private String sn;
	private Long position_id;
	private Long department_id;
	private String name;
	private String password;
	private String status;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */

	public Employee(String sn, Long position_id, Long department_id,
			String name, String password, String status) {
		super();
		this.sn = sn;
		this.position_id = position_id;
		this.department_id = department_id;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	// Property accessors

	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Long getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Long position_id) {
		this.position_id = position_id;
	}

	public Long getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}