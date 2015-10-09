package com.jboa.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ClaimVoucherUtil {
	private Long id;
	private String create_time;
	private String create_name;
	private Double total_account;
	private String status;
	private String next_deal_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss").format(create_time);
	}

	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	public Double getTotal_account() {
		return total_account;
	}

	public void setTotal_account(Double total_account) {
		this.total_account = total_account;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNext_deal_name() {
		return next_deal_name;
	}

	public void setNext_deal_name(String next_deal_name) {
		this.next_deal_name = next_deal_name;
	}

}
