package com.suoyi.entity;

import java.util.Date;

public class Leave extends BaseBean {
	private int createid,// 创建者
	        nextopid;// 下一个处理人

	private String reason,// 请假缘由
	        opresult,// 审批结果
	        state,// 审批状态
	        opdes;// 审批意见
	private Date createtime,// 创建时间
	        starttime,// 开始时间
	        endtime;// 结束时间

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
