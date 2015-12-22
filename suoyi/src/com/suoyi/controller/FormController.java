package com.suoyi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suoyi.controller.util.ControllerUtil;
import com.suoyi.entity.UserBean;
import com.suoyi.service.dao.BaseService;
import com.suoyi.service.util.ServiceUtil;
import com.suoyi.sys.ContextManager;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class FormController {

	@RequestMapping(value = "/sys/form.do")
	public String doForm(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			UserBean user = ContextManager.getCurUser(request);
			Map map_1 = ServiceUtil.getReqParam(request);
			map_1.put("user", user);
			String svc = (String) map_1.get("svc");
			String action = (String) map_1.get("action");

			if (svc == null ||"null".equals(svc)|| svc.length() <= 0) {
				svc = "BaseServiceImpl";
			}

			BaseService service = (BaseService) ServiceUtil.getBean(svc);
			
			if ("add".equals(action)) {
				service.add(map_1);
				ControllerUtil.writeResult(response, "操作成功!");
			}else if("edit".equals(action)){
				service.edit(map_1);
				ControllerUtil.writeResult(response, "操作成功!");
			}

		} catch (Exception e) {
			model.addAttribute("error_msg", e.getLocalizedMessage());
			e.printStackTrace();
			return "jsp/error.jsp";
		}

		return "";
	}

}
