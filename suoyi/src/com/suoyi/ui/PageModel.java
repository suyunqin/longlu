package com.suoyi.ui;

import java.util.HashMap;
import java.util.Map;

import com.suoyi.ui.form.Form;
import com.suoyi.ui.qlist.QueryList;

public class PageModel {
	private String id;
	private String type;
	private QueryList querylist;
	private Map<String, Form> forms = new HashMap<String, Form>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public QueryList getQuerylist() {
		return querylist;
	}

	public void setQuerylist(QueryList querylist) {
		this.querylist = querylist;
	}

	public Map<String, Form> getForms() {
		return forms;
	}

	public void setForms(Map<String, Form> forms) {
		this.forms = forms;
	}
	
	public void putForm(Form form){
		this.forms.put(form.getId(), form);
	}
	public Form getFormById(String formid){
		return this.forms.get(formid);
	}
}
