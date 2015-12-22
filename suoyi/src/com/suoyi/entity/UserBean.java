package com.suoyi.entity;

@SuppressWarnings("serial")
public class UserBean extends BaseBean {
	
	private String sn;
	private Department dept;
	private Position pos;
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	

}
