package com.suoyi.ui;

import java.util.List;

import com.suoyi.ui.qlist.QueryList;

public class PageModel {
	private String id;
	private String type;
	private QueryList querylist;

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

}
