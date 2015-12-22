package com.suoyi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suoyi.service.dao.BaseService;
import com.suoyi.service.util.ServiceUtil;

@Controller
public class CallServiceController {

	@RequestMapping(value = "callservice.do")
	public String callService(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			Map list_1 = null;
			Map map_1 = ServiceUtil.getReqParam(request);
			
			String action = (String) map_1.get("action");
			String svc = (String) map_1.get("svc");
			if (svc == null ||"null".equals(svc)|| svc.length() <= 0) {
				svc = "BaseServiceImpl";
			}
			if("getDate".equals(action)){
				
				BaseService service = (BaseService) ServiceUtil.getBean(svc);
				list_1 = service.getData(map_1);
				
			}
			
			return "";
		} catch (Exception e) {
			model.addAttribute("error_msg", e.getLocalizedMessage());
			e.printStackTrace();
			return "jsp/error.jsp";
		}
	}
	
}
