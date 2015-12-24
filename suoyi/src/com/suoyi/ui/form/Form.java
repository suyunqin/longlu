package com.suoyi.ui.form;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private String id;
	private List<FormField> fields = new ArrayList<FormField>();
	private String hibean;
	private String svc;
	private String hiddefbtn;
	private String btnlabel;
	private String defcon;
	private String order;

	public String getDefcon() {
		return defcon;
	}

	public void setDefcon(String defcon) {
		this.defcon = defcon;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getBtnlabel() {
		return btnlabel;
	}

	public void setBtnlabel(String btnlabel) {
		this.btnlabel = btnlabel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<FormField> getFields() {
		return fields;
	}

	public void setFields(List<FormField> fields) {
		this.fields = fields;
	}

	public String getHibean() {
		return hibean;
	}

	public void setHibean(String hibean) {
		this.hibean = hibean;
	}

	public String getSvc() {
		return svc;
	}

	public void setSvc(String svc) {
		this.svc = svc;
	}

	public String getHiddefbtn() {
		return hiddefbtn;
	}

	public void setHiddefbtn(String hiddefbtn) {
		this.hiddefbtn = hiddefbtn;
	}

}
