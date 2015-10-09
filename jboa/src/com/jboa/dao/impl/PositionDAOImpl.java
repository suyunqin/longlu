package com.jboa.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.jboa.entity.Position;

public class PositionDAOImpl implements com.jboa.dao.PositionDAO {
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public Position findById(Long id) {
		return sqlSessionTemplate.selectOne("positionDao.findById", id);
	}
}
