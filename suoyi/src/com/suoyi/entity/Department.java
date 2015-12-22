package com.suoyi.entity;

import java.util.List;

public class Department extends BaseBean {
	private List<Emp> emps;

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	
}
