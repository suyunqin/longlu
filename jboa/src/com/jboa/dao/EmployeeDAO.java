package com.jboa.dao;

import com.jboa.entity.Employee;

public interface EmployeeDAO {
	public Employee findById(String empId);
}
