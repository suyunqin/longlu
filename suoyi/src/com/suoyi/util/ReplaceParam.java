package com.suoyi.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.suoyi.entity.Leave;

public class ReplaceParam {

	public static String replaceHrefByBean(String href, Object bean) {

		if (StringUtils.isNotBlank(href) && bean != null) {

			while (href.indexOf("{") >= 0) {
				int begin = href.indexOf("{");
				int end = href.indexOf("}");
				String parampname = href.substring(begin, end + 1);
				String propname = parampname.substring(1,
						parampname.length() - 1);

				try {
					Object value = PropertyUtils.getProperty(bean, propname);
					if (value != null && value.toString().length() != 0) {
						href = href.replace(parampname, value.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}

		return href;
	}

	public static void main(String[] a) {
		String href = "asdasd{id}";
		Leave leave = new Leave();
		leave.setId(100);
		href = replaceHrefByBean(href, leave);
		System.out.println(href);
	}

}
