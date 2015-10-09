package com.jboa.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.jboa.dao.LeaveDAO;

public class LeaveDAOImpl implements LeaveDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
