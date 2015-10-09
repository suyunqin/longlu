package com.jboa.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jboa.dao.ClaimVoucherDAO;
import com.jboa.dao.EmployeeDAO;
import com.jboa.dao.PositionDAO;
import com.jboa.entity.ClaimVoucher;
import com.jboa.util.ClaimVoucherUtil;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		 EmployeeDAO dao = (EmployeeDAO) context.getBean("employeeDAO");
//		 System.out.println(dao.findById("017").getName());
		// PositionDAO dao = (PositionDAO) context.getBean("positionDAO");
		// System.out.println(dao.findById(1L).getNameCn());

		ClaimVoucherDAO dao = (ClaimVoucherDAO) context
				.getBean("claimVoucherDAO");
		List<ClaimVoucherUtil> list = dao.findByPage(1, 10, "001");
		for (ClaimVoucherUtil c : list) {
			System.out.println(c.getCreate_time());
		}
//		System.out.println(dao.getClaimVoucherCount());
		
//		System.out.println(dao.getClaimVoucherCountBySn("001"));
	}
}
