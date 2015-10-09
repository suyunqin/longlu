package com.jboa.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.jboa.dao.EmployeeDAO;
import com.jboa.dao.PositionDAO;
import com.jboa.entity.Employee;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author qiu11
 * 
 */
public class LoginAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session = new HashMap<String, Object>();
	private String empId;
	private String password;
	private boolean result = false;
	private EmployeeDAO employeeDAO;
	private PositionDAO positionDAO;

	public String login() {
		Employee emp = null;

		emp = this.employeeDAO.findById(empId);

		if (emp != null && emp.getPassword().equals(password)) {
			String posion_name = this.positionDAO
					.findById(emp.getPosition_id()).getNameCn();
			this.session.put("position", posion_name);
			this.session.put("user", emp);
			result = true;
		}

		return SUCCESS;
	}

	public String isLogin() {

		if (this.session.get("user") != null) {
			this.result = true;
		}
		return SUCCESS;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setPositionDAO(PositionDAO positionDAO) {
		this.positionDAO = positionDAO;
	}

}
