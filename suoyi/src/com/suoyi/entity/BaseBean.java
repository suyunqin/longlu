package com.suoyi.entity;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class BaseBean implements Serializable {
	private long id;
	private String name;
	private int opid;
	private Date optime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOpid() {
		return opid;
	}

	public void setOpid(int opid) {
		this.opid = opid;
	}

	public Date getOptime() {
		return optime;
	}

	public void setOptime(Date optime) {
		this.optime = optime;
	}

}
