package com.suoyi.service.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.suoyi.entity.sys.PageBean;
import com.suoyi.sys.ContextManager;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ServiceUtil implements ApplicationContextAware {
	
	private static ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		context = ctx;
	}
	/**
	 * 获取bean
	 * @param beanid
	 * @return
	 */
	public static Object getBean(String beanname) {
		Object result = null;
		if (context != null) {
			result = context.getBean(beanname);
		}else{
			context = WebApplicationContextUtils.getWebApplicationContext(ContextManager.context);
			result = context.getBean(beanname);
		}
		return result;
	}
	
	
    public static Map getReqParam(HttpServletRequest req){
		Map map_1 = new HashMap();
		
		Map reqParam = req.getParameterMap();
		
		Iterator<String> keys = reqParam.keySet().iterator();
		
		while(keys.hasNext()){
			String key = keys.next();
			String value = (String) ((Object[])reqParam.get(key))[0];
			if(StringUtils.isNotBlank(value)&&!"-全部-".equals(value)){
				map_1.put(key, value);
			}
		}
		
		map_1.put("sessionid", req.getSession().getId());
		
		return map_1;
	}
}
