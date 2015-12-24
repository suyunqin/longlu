package com.suoyi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suoyi.entity.BaseBean;
import com.suoyi.entity.UserBean;
import com.suoyi.service.dao.BaseService;
import com.suoyi.service.util.ServiceUtil;
import com.suoyi.sys.ContextManager;
import com.suoyi.ui.PageModel;
import com.suoyi.ui.form.Form;
import com.suoyi.ui.form.FormField;
import com.suoyi.util.SessionUtil;

@Controller
@SuppressWarnings({ "unchecked", "rawtypes" })
public class FormController {

	@RequestMapping(value = "/form.do")
	public String doForm(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			UserBean user = ContextManager.getCurUser(request);
			if (user == null) {
				return "redirect:welcome.do";
			}
			Map map_1 = ServiceUtil.getReqParam(request);
			map_1.put("user", user);
			String target = (String) map_1.get("target");
			if (StringUtils.isBlank(target)) {
				throw new Exception("目标页面[" + target + "]不存在!");
			}
			String formid = (String) map_1.get("formid");
			String dialogid = (String) map_1.get("dialogid");
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
			String svcMethod = "";
			if (StringUtils.isBlank(svc)) {
				svc = "BaseServiceImpl";
			} else {
				if (svc.indexOf(".") >= 0) {
					svcMethod = svc.substring(svc.indexOf(".") + 1,
							svc.length());
					svc = svc.substring(0, svc.indexOf("."));
				}
			}
			Object bean = null;
			if ("add".equals(action)) {
				if (StringUtils.isBlank(svcMethod)) {
					svcMethod = "add";
				}
				if ("map".equals(bean)) {
					bean = new HashMap();
				} else {
					bean = (BaseBean) Class.forName(
							"com.suoyi.entity." + hibean).newInstance();
				}
			} else if ("edit".equals(action)) {
				if (StringUtils.isBlank(svcMethod)) {
					svcMethod = "edit";
				}
				if (hibean.equals("map")) {
					bean = new HashMap();
				} else {
					String pk = (String) map_1.get("pk");
					model.addAttribute("pk", pk);
					bean = SessionUtil.getSession().get(
							Class.forName("com.suoyi.entity." + hibean),
							new Long(pk));
					if (bean == null) {
						bean = Class.forName("com.suoyi.entity." + hibean)
								.newInstance();
					}
				}
			}
			map_1.put("session", request.getSession());
			map_1.put("req", request);
			map_1.put("bean", bean);
			BaseService service = (BaseService) ServiceUtil.getBean(svc);

			if ("add".equals(action)) {
				service.preAdd(map_1);
			} else if ("edit".equals(action)) {
				service.preEdit(map_1);
			}
			if (map_1.containsKey("bean")) {
				bean = map_1.get("bean");
			}
			String btnlabel = form.getBtnlabel();
			if (StringUtils.isBlank(btnlabel)) {
				btnlabel = "保存";
			}

			if (bean != null) {
				Map valueMap = getValueMap(form, bean);
				if(dialogid!=null)
					valueMap.put("dialogid", dialogid);
				model.addAttribute("valueMap", valueMap);
			}else{
				model.addAttribute("valueMap", new HashMap());
			}
			model.addAttribute("svcName", svc);
			model.addAttribute("svcMethod", svcMethod);
			model.addAttribute("user", user);
			model.addAttribute("btnlabel", btnlabel);
			model.addAttribute("action", action);

			return "jsp/form.jsp";
		} catch (Exception e) {
			model.addAttribute("error_msg", e.getMessage());
			e.printStackTrace();
			return "jsp/error.jsp";
		}

	}

	private Map getValueMap(Form form, Object bean) throws Exception {
		Map values = new HashMap();
		List<FormField> fields = form.getFields();
		for (FormField field : fields) {
			try{
			values.put(field.getField(),
					PropertyUtils.getProperty(bean, field.getField()));
			}catch (Exception e){
				if(!e.getMessage().startsWith("Null property value for")){
					throw e;
				}
			}
		}
		return values;
	}

}
