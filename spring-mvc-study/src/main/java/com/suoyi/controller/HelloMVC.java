package com.suoyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloMVC {
	@RequestMapping("/mvc")
	public String helloMVC(){
		return "sayHello";
	}
}
