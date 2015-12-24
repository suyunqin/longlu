package com.suoyi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suoyi.controller.util.ControllerUtil;
import com.suoyi.entity.UserBean;
import com.suoyi.service.dao.BaseService;
import com.suoyi.service.util.ServiceUtil;
import com.suoyi.sys.ContextManager;
import com.suoyi.ui.PageModel;
import com.suoyi.ui.form.Form;

@Controller
public class FormSubmitController {
	
	@RequestMapping(value="submit.do")
	public void doSubmit(HttpServletRequest request,HttpServletResponse response,Model model){
//		StringBuffer result = new StringBuffer("<script type=\"text/javascript\">");
		StringBuffer result = new StringBuffer();
		String dialogid="";
		try{
			
			UserBean user = ContextManager.getCurUser(request);
			Map map_1 = ServiceUtil.getReqParam(request);
			map_1.put("user", user);
			dialogid = (String) map_1.get("dialogid");
			String target = (String) map_1.get("target");
			if (StringUtils.isBlank(target)) {
				throw new Exception("目标页面[" + target + "]不存在!");
			}
			String formid = (String) map_1.get("formid");
			if (StringUtils.isBlank(formid)) {
				throw new Exception("form[" + formid + "]未定义!");
			}
			PageModel page = ContextManager.getPageByTarget(target);
			Form form = page.getFormById(formid);
			if (form == null) {
				throw new Exception("页面[" + target + "]中不包含form[" + formid + "]!");
			}
			String action = (String) map_1.get("action");
			if (StringUtils.isBlank(action)) {
				action = "add";
			}
			String hibean = form.getHibean();
			if (StringUtils.isBlank(hibean)) {
				throw new Exception("form[" + formid + "],未设置绑定实体!");
			}
			String svc = form.getSvc();
			if (StringUtils.isBlank(svc)) {
				svc = "BaseServiceImpl";
			} 
			map_1.put("session", request.getSession());
			map_1.put("req", request);
			map_1.put("hibean", form.getHibean());
			BaseService service = (BaseService) ServiceUtil.getBean(svc);
			
			if("add".equals(action)){
				service.add(map_1);
			}else if("edit".equals(action)){
				service.edit(map_1);
			}
			result.append("{\"val\":\"ok\",\"dialogid\":\""+dialogid+"\"}");
		}catch(Exception e){
			result.append("{\"error\":\""+e.getMessage()+"\"}");
		}finally{
			ControllerUtil.writeResult(response, result);
		}
	}
	
}
