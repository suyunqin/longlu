package com.suoyi.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import com.suoyi.sys.ContextManager;

public class MyListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("init springContext start...");
		long start = System.currentTimeMillis();
		super.contextInitialized(event);
		System.out.println("springContext初始化工作完成,耗时："+(System.currentTimeMillis()-start)+"ms ...springContext Initialized sucess");
		ContextManager.context = event.getServletContext();
		ContextManager.init();
	}
	
}
