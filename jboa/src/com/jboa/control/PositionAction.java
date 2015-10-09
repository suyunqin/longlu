package com.jboa.control;

import com.jboa.dao.PositionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PositionAction extends ActionSupport {
	private PositionDAO positionDAO;

	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}

}
