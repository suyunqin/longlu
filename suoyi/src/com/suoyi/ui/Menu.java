package com.suoyi.ui;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private int id;
	private String name;
	private String href;
	private List<Button> btns = new ArrayList<Button>();
	private String mouseIn = "showBtns";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public List<Button> getBtns() {
		return btns;
	}

	public void setBtns(List<Button> btns) {
		this.btns = btns;
	}

	public String getMouseIn() {
		return mouseIn;
	}

	public void setMouseIn(String mouseIn) {
		this.mouseIn = mouseIn;
	}

}
