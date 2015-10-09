package com.jboa.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.jboa.dao.DepartmentDAO;

public class DepartmentDAOImpl implements DepartmentDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
