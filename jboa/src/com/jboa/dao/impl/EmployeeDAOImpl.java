package com.jboa.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.jboa.dao.EmployeeDAO;
import com.jboa.entity.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public Employee findById(String empId) {
		return sqlSessionTemplate.selectOne("employeeDao.findByNo",empId);
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

}
