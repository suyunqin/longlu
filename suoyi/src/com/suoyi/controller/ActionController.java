package com.suoyi.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.suoyi.entity.UserBean;
import com.suoyi.entity.sys.PageBean;
import com.suoyi.service.dao.BaseService;
import com.suoyi.service.util.ServiceUtil;
import com.suoyi.sys.ContextManager;
import com.suoyi.ui.PageModel;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Controller
public class ActionController {

	@RequestMapping(value = "/action.do")
	public ModelAndView doAction(HttpServletRequest request, HttpServletResponse response, Map model) {
		try {
			UserBean user = ContextManager.getCurUser(request);
			Map map_1 = ServiceUtil.getReqParam(request);
			String target = (String) map_1.get("target");
			model.put("search_map", map_1);
			PageModel pageModel = ContextManager.getPageByTarget(target);

			String action = (String) map_1.get("action");
			String svc = pageModel.getQuerylist().getSearch_form().getSvc();

			if (svc == null || svc.length() == 0) {
				svc = "BaseServiceImpl";
			}
			
			if (action == null || action.length() == 0) {
				action = "queryForm";
			}
			
			map_1.put("action", action);
			map_1.put("request", request);
			map_1.put("target", target);

			if ("queryForm".equals(action)) {

				BaseService service = (BaseService) ServiceUtil.getBean(svc);
				PageBean pageB = new PageBean();

				if (map_1.get("curPage") == null) {
					pageB.setCurPage(1);
				}else{
					pageB.setCurPage(Integer.parseInt(map_1.get("curPage").toString()));
				}

				if (map_1.get("pageSize") == null) {
					pageB.setPageSize(15);
				}else{
					pageB.setPageSize(Integer.parseInt(map_1.get("pageSize").toString()));
				}
				map_1.put("pageB", pageB);
				
				Map data = service.getData(map_1);
				model.put("datas", data);
				model.put("map_1", map_1);
				
			}
			return new ModelAndView("jsp/show_list.jsp", model);
		} catch (Exception e) {
			e.printStackTrace();
			model.put("error_msg", e.toString());
			return new ModelAndView("jsp/error.jsp", model);
		}

	}

}
