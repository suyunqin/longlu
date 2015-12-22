package com.suoyi.ui.qlist;

import java.util.ArrayList;
import java.util.List;

public class QueryList {
	private String svc;
	private String hibean;
	private List<SearchField> search = new ArrayList<SearchField>();

	private List<ContentTD> content = new ArrayList<ContentTD>();

	public String getSvc() {
		return svc;
	}

	public void setSvc(String svc) {
		this.svc = svc;
	}

	public String getHibean() {
		return hibean;
	}

	public void setHibean(String hibean) {
		this.hibean = hibean;
	}

	public List<SearchField> getSearch() {
		return search;
	}

	public void setSearch(List<SearchField> search) {
		this.search = search;
	}

	public List<ContentTD> getContent() {
		return content;
	}

	public void setContent(List<ContentTD> content) {
		this.content = content;
	}

}
