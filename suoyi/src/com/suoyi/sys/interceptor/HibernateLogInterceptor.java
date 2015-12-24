package com.suoyi.sys.interceptor;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

@SuppressWarnings("serial")
public class HibernateLogInterceptor extends EmptyInterceptor {

	private static Logger logger = Logger
			.getLogger(HibernateLogInterceptor.class);

	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		return super.onSave(entity, id, state, propertyNames, types);
	}

}
