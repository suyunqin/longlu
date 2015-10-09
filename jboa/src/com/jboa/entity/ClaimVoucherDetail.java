package com.jboa.entity;

/**
 * ClaimVoucherDetail entity. @author MyEclipse Persistence Tools
 */

public class ClaimVoucherDetail implements java.io.Serializable {

	// Fields

	private Long id;
	private Long main_id;
	private String item;
	private Double account;
	private String des;

	// Constructors

	/** default constructor */
	public ClaimVoucherDetail() {
	}

	/** full constructor */
	public ClaimVoucherDetail(Long id, Long main_id, String item,
			Double account, String des) {
		super();
		this.id = id;
		this.main_id = main_id;
		this.item = item;
		this.account = account;
		this.des = des;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMain_id() {
		return main_id;
	}

	public void setMain_id(Long main_id) {
		this.main_id = main_id;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public Double getAccount() {
		return this.account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}