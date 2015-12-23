package com.suoyi.ui.qlist;


import com.suoyi.ui.form.Form;

public class QueryList {
	Form search_form = new Form();
	Content content = new Content();

	public Form getSearch_form() {
		return search_form;
	}

	public void setSearch_form(Form search_form) {
		this.search_form = search_form;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

}
