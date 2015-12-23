package com.suoyi.controller.util;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.suoyi.sys.ContextManager;
import com.suoyi.ui.PageModel;
import com.suoyi.ui.qlist.ContentTD;

public class ControllerUtil {

	public static void writeResult(HttpServletResponse response, Object result) {
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			out = response.getWriter();
			out.print(result.toString());
		} catch (Exception e) {

		} finally {
			out.flush();
			out.close();
		}
	}

	@SuppressWarnings("rawtypes")
    public static JSONObject getJsonResult(Map data, Map map_1) throws Exception {
		JSONObject result = new JSONObject();
		
		if (data != null && data.size() > 0) {
			result.put("total", data.get("total"));
			List list_1 = (List) data.get("rows");
			JSONArray rows = new JSONArray();
			PageModel pageModel = ContextManager.getPageByTarget((String) map_1.get("target"));
			List<ContentTD> tds = pageModel.getQuerylist().getContent().getContent();
			for (Object obj : list_1) {
				JSONObject jobj = new JSONObject();
				for (ContentTD td : tds) {
					jobj.put(td.getField(), PropertyUtils.getProperty(obj,td.getField()));
				}
				rows.put(jobj);
			}
			result.put("rows", rows);
		}

		return result;
	}
}
