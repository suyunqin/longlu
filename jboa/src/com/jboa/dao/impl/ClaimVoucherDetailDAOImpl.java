package com.jboa.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.jboa.dao.ClaimVoucherDetailDAO;

public class ClaimVoucherDetailDAOImpl implements ClaimVoucherDetailDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
}
