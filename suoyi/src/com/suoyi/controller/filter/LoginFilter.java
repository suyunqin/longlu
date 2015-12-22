package com.suoyi.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suoyi.controller.util.ControllerUtil;
import com.suoyi.entity.UserBean;
import com.suoyi.sys.ContextManager;

public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest requests = (HttpServletRequest) request;
		UserBean user = ContextManager.getCurUser(requests);
		String url = requests.getRequestURI();

		if (user == null && !url.endsWith("login.do") && !url.endsWith("welcome.do")) {
			StringBuffer result = new StringBuffer("<script type=\"text/javascript\">");
			// result.append("alert(\"回话已过期请重新登录!\");");
			result.append("location.href=\"welcome.do\";");
			result.append("</script>");
			ControllerUtil.writeResult((HttpServletResponse) response, result);
			// requests.getRequestDispatcher("welcome.do").forward(requests,
			// response);
		} else {
			chain.doFilter(requests, response);
		}
	}

	@Override
	public void destroy() {

	}

}
