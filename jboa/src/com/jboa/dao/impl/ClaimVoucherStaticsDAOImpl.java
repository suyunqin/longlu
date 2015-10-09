package com.jboa.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

public class ClaimVoucherStaticsDAOImpl implements
		com.jboa.dao.ClaimVoucherStaticsDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
