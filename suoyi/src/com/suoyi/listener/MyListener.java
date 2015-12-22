package com.suoyi.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.suoyi.sys.ContextManager;

public class MyListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		ContextManager.context = event.getServletContext();
		ContextManager.init();
		System.out.println("应用监听器初始化工作完成...contextInitialized sucess");
	}
	
}
