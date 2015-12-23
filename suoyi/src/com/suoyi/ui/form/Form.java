package com.suoyi.ui.form;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private List<FormField> fields = new ArrayList<FormField>();
	private String hibean;
	private String svc;
	private String hiddefbtn;
	
	
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
