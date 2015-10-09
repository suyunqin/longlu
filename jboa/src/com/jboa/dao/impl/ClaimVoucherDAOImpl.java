package com.jboa.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;

import com.jboa.dao.ClaimVoucherDAO;
import com.jboa.entity.ClaimVoucher;
import com.jboa.util.ClaimVoucherUtil;

public class ClaimVoucherDAOImpl implements ClaimVoucherDAO {
	private final String NAMESPACE = "claimVoucherDao.";
	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public List<ClaimVoucher> findByCreateSn(String sn) {
		return this.sqlSessionTemplate.selectList(this.NAMESPACE
				+ "findByCreateSn", sn);
	}

	@Override
	public List<ClaimVoucherUtil> findByPage(int page, int size, String sn) {

		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("page", page);
		paraMap.put("size", size);
		paraMap.put("create_sn", sn);

		List<ClaimVoucherUtil> list = this.sqlSessionTemplate.selectList(
				this.NAMESPACE + "findByPage", paraMap);

		return list;
	}

	@Override
	public Long getClaimVoucherCount() {
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE
				+ "getClaimVoucherCount");
	}

	@Override
	public ClaimVoucher findById(Long claimID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getClaimVoucherCountBySn(String sn) {
		// TODO Auto-generated method stub
		return this.sqlSessionTemplate.selectOne(this.NAMESPACE
				+ "getClaimVoucherCountBySn", sn);
	}
}
