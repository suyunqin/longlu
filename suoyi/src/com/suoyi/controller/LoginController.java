package com.suoyi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.suoyi.controller.util.ControllerUtil;
import com.suoyi.entity.Emp;
import com.suoyi.entity.UserBean;
import com.suoyi.service.util.ServiceUtil;
import com.suoyi.sys.ContextManager;
import com.suoyi.util.SessionUtil;

@Controller
@SuppressWarnings("rawtypes")
public class LoginController {

	@RequestMapping(value = "login.do")
	public String doLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		try {
			Map map_1 = ServiceUtil.getReqParam(request);
			StringBuffer msg = new StringBuffer();

			if (checkParam(map_1, msg)) {
				UserBean user = ContextManager.getCurUser(request);
				if (user == null) {
					Emp emp = (Emp) SessionUtil.getSession().createQuery("From Emp where sn = '" + map_1.get("sn") + "' and pass = '" + map_1.get("pass") + "'").setMaxResults(1).uniqueResult();

					if (emp == null) {
						msg.setLength(0);
						msg.append("<script type=\"text/javascript\">alert(\"用户名或密码不存在!\");location.href=\"");
						msg.append(ContextManager.context.getContextPath());
						msg.append("\";</script>");
						ControllerUtil.writeResult(response, msg.toString());
					}

					user = new UserBean();
					user.setId(emp.getId());
					user.setName(emp.getName());
					user.setSn(emp.getSn());
					user.setDept(emp.getDept());
					user.setPos(emp.getPosi());

					ContextManager.addOnLineUser((String) map_1.get("sessionid"), user);
				}

				msg.setLength(0);
				msg.append("<script type=\"text/javascript\">location.href=\"goIndex.do\";</script>");
				ControllerUtil.writeResult(response, msg.toString());
				return "";
			} else {
				StringBuffer error_msg = new StringBuffer("<script type=\"text/javascript\">");
				error_msg.append("alert(\"" + msg.toString() + "\");");
				error_msg.append("location.href=\"" + ContextManager.context.getContextPath() + "\";");
				error_msg.append("</script>");
				ControllerUtil.writeResult(response, error_msg);
				return "";
			}

		} catch (Exception e) {
			model.addAttribute("error_msg", e.getLocalizedMessage());
			return "jsp/error.jsp";
		}
	}

	@RequestMapping(value="deLogin.do")
	public String deLogin(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		try {
			StringBuffer result = new StringBuffer("<script type=\"text/javascript\">");
			result.append("location.href=\"" + ContextManager.context.getContextPath() + "\";");
			result.append("</script>");
			ContextManager.removeUser(request);
			ControllerUtil.writeResult(response, result);
			return "";
		} catch (Exception e) {
			model.addAttribute("error_msg", e.getLocalizedMessage());
			return "jsp/error.jsp";
		}
	}

	private boolean checkParam(Map param, StringBuffer msg) {
		if (StringUtils.isBlank((String) param.get("sn"))) {
			msg.append("请输入用户名");
			return false;
		}
		if (StringUtils.isBlank((String) param.get("pass"))) {
			msg.append("请输入密码");
			return false;
		}
		return true;
	}

}
