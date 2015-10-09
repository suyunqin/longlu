package com.jboa.dao;

import java.util.List;

import com.jboa.entity.ClaimVoucher;
import com.jboa.util.ClaimVoucherUtil;

public interface ClaimVoucherDAO {
	List<ClaimVoucher> findByCreateSn(String sn);

	List<ClaimVoucherUtil> findByPage(int page, int size, String sn);

	Long getClaimVoucherCount();

	ClaimVoucher findById(Long claimID);
	
	Long getClaimVoucherCountBySn(String sn);
}
