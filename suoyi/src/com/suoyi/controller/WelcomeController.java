package com.suoyi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suoyi.controller.util.ControllerUtil;
import com.suoyi.sys.ContextManager;

@Controller
public class WelcomeController {
	
	@RequestMapping(value="welcome.do")
	public String welcome(HttpServletRequest request,HttpServletResponse response){
		return "login.html";
	}
	
	@RequestMapping(value="goIndex.do")
	public String goIndex(){
		return "jsp/index.jsp";
	}
}
