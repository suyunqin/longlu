package com.suoyi.entity;

import java.util.Date;

public class Leave extends BaseBean {
	private int createid,// ������
	        nextopid;// ��һ��������

	private String reason,// ���Ե��
	        opresult,// �������
	        state,// ����״̬
	        opdes;// �������
	private Date createtime,// ����ʱ��
	        starttime,// ��ʼʱ��
	        endtime;// ����ʱ��

	private Emp creater;
	private Emp oper;

	public int getCreateid() {
		return createid;
	}

	public void setCreateid(int createid) {
		this.createid = createid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOpresult() {
		return opresult;
	}

	public void setOpresult(String opresult) {
		this.opresult = opresult;
	}

	public String getOpdes() {
		return opdes;
	}

	public void setOpdes(String opdes) {
		this.opdes = opdes;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Emp getCreater() {
		return creater;
	}

	public void setCreater(Emp creater) {
		this.creater = creater;
	}

	public Emp getOper() {
		return oper;
	}

	public void setOper(Emp oper) {
		this.oper = oper;
	}

	public int getNextopid() {
		return nextopid;
	}

	public void setNextopid(int nextopid) {
		this.nextopid = nextopid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
