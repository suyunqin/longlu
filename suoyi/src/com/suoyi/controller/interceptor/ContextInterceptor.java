package com.suoyi.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.suoyi.sys.ContextManager;

public class ContextInterceptor extends HandlerInterceptorAdapter {
	static Logger logger = Logger.getLogger(ContextInterceptor.class);	
	 
	 @Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		 if(ContextManager.context==null){
			 logger.debug("context is null reget!");;
			 ContextManager.context = request.getServletContext();
		 }
		 return super.preHandle(request, response, handler);
	}
}	
