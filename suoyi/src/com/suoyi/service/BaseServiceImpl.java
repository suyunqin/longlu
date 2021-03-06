package com.suoyi.service;

import java.beans.PropertyDescriptor;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Session;

import com.suoyi.entity.BaseBean;
import com.suoyi.entity.UserBean;
import com.suoyi.entity.sys.PageBean;
import com.suoyi.myexceptions.LogicalException;
import com.suoyi.service.dao.BaseService;
import com.suoyi.sys.ContextManager;
import com.suoyi.ui.form.Form;
import com.suoyi.ui.form.FormField;
import com.suoyi.ui.qlist.QueryList;
import com.suoyi.util.DateHandler;
import com.suoyi.util.SessionUtil;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseServiceImpl implements BaseService {

	@Override
	public void preAdd(Map map_1) throws Exception {
	}

	@Override
	public void add(Map map_1) throws Exception {
		BaseBean bean = createBean(map_1);
		UserBean user = (UserBean) map_1.get("user");
		if (bean != null) {
			bean.setOpid(new Long(user.getId()).intValue());
			bean.setOptime(new Date());
			SessionUtil.beginTx();
			SessionUtil.getSession().save(bean);
			map_1.put("pk", bean.getId());
			SessionUtil.commit();
		}
	}

	public BaseBean createBean(Map map_1) throws Exception {
//		BaseBean bean = null;
//
//		String beaname = (String) map_1.get("hibean");
//
//		if (!beaname.startsWith("com.suoyi.entity."))
//			beaname = "com.suoyi.entity." + beaname;
//
//		bean = (BaseBean) Class.forName(beaname).newInstance();
//
//		PropertyDescriptor[] propDescs = PropertyUtils.getPropertyDescriptors(bean);
//
//		for (PropertyDescriptor prop : propDescs) {
//
//			if (prop.getWriteMethod() == null) {
//				continue;
//			}
//
//			String fieldName = prop.getName();
//
//			try {
//				// 字段类型
//				String fieldType = String.valueOf(prop.getPropertyType());
//				String val = null;
//
//				val = ((String) map_1.get(fieldName));
//
//				if (val == null)
//					continue;
//				Object obj = null;
//				val = val.trim();
//
//				if (val.length() <= 0) {
//					continue;
//				}
//
//				if (fieldType.endsWith("Date")) {
//					if (val.length() > 10) {
//						obj = DateHandler.sdf_noss.parse(val);
//					} else if (val.length() > 0) {
//						obj = DateHandler.sdf_notime.parse(val);
//					}
//				} else if (fieldType.endsWith("String")) {
//					obj = val;
//				} else {
//					if (val.length() == 0)
//						val = "0";
//					if (fieldType.equals("int") || fieldType.endsWith("Integer")) {
//						obj = new Integer(val);
//					} else if (fieldType.equals("long") || fieldType.endsWith("Long")) {
//						obj = new Long(val);
//					} else if (fieldType.equals("double") || fieldType.endsWith("Double")) {
//						obj = new Double(val);
//					} else if (fieldType.equals("float") || fieldType.endsWith("Float")) {
//						obj = new Float(val);
//					}
//				}
//				PropertyUtils.setProperty(bean, fieldName, obj);
//
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new LogicalException("创建实体类时出现错误  error property:" + fieldName, e);
//			}
//		}

		return setBeanForUpdate(null, map_1);
	}

	@Override
	public void preEdit(Map map_1) throws Exception {

	}

	@Override
	public void edit(Map map_1) throws Exception {
		String pk = (String) map_1.get("pk");
		if(pk==null){
			throw new LogicalException("pk 为必选参数!");
		}
		String hibean = (String) map_1.get("hibean");
		SessionUtil.beginTx();
		BaseBean bean = (BaseBean) SessionUtil.getSession().get("com.suoyi.entity."+hibean, new Long(pk));
		bean = setBeanForUpdate(bean, map_1);
		SessionUtil.getSession().update(bean);
		SessionUtil.commit();
	}

	public BaseBean setBeanForUpdate(BaseBean bean,Map map_1) throws Exception {
		String beaname = (String) map_1.get("hibean");
		if (!beaname.startsWith("com.suoyi.entity."))
			beaname = "com.suoyi.entity." + beaname;
		if(bean==null){
			bean = (BaseBean) Class.forName(beaname).newInstance();
		}
		PropertyDescriptor[] propDescs = PropertyUtils.getPropertyDescriptors(bean);
		for (PropertyDescriptor prop : propDescs) {
			if (prop.getWriteMethod() == null) {
				continue;
			}
			String fieldName = prop.getName();
			try {
				// 字段类型
				String fieldType = String.valueOf(prop.getPropertyType());
				
				Object obj = map_1.get(fieldName);
				if(obj==null){
					continue;
				}
				if (obj.toString().length() <= 0) {
					continue;
				}
				if (fieldType.endsWith("Date")) {
					if (obj.toString().length() > 10) {
						obj = DateHandler.sdf_noss.parse(obj.toString());
					} else {
						obj = DateHandler.sdf_notime.parse(obj.toString());
					}
				} else {
					if (obj.toString().length() == 0)
						obj = "0";
					if (fieldType.equals("int") || fieldType.endsWith("Integer")) {
						obj = new Integer(obj.toString());
					} else if (fieldType.equals("long") || fieldType.endsWith("Long")) {
						obj = new Long(obj.toString());
					} else if (fieldType.equals("double") || fieldType.endsWith("Double")) {
						obj = new Double(obj.toString());
					} else if (fieldType.equals("float") || fieldType.endsWith("Float")) {
						obj = new Float(obj.toString());
					}
				}
				PropertyUtils.setProperty(bean, fieldName, obj);
			} catch (Exception e) {
				e.printStackTrace();
				throw new LogicalException("error property:" + fieldName, e);
			}
		}
		return bean;
	}
	
	@Override
	public Map getData(Map map_1) throws Exception {
		Map data = new HashMap();

		QueryList ql = ContextManager.getPageByTarget(map_1.get("target").toString()).getQuerylist();
		
		Form search_form = ql.getSearch_form();
		
		String beanName = search_form.getHibean();

		if (StringUtils.isBlank(beanName)) {
			throw new LogicalException("no bean find ");
		}

		StringBuffer sb_from = new StringBuffer(" From ");
		StringBuffer sb_cond = getCond(map_1);
		StringBuffer sb_count = new StringBuffer("select count(1) From ");
		String order = search_form.getOrder();
		
		sb_from.append(beanName);
		sb_count.append(beanName);
		Session s = SessionUtil.getSession();
		List list_1 = null;
		
		PageBean pageb = (PageBean) map_1.get("pageB");

		int first = (pageb.getCurPage() - 1) * pageb.getPageSize();

		String qstr = sb_from.toString() + sb_cond + order;

		list_1 = s.createQuery(qstr).setMaxResults(pageb.getPageSize()).setFirstResult(first).list();
		
		String cstr = sb_count.toString() + sb_cond;
		Long count = (Long) s.createQuery(cstr).uniqueResult();
		
		pageb.setCount(count.intValue());
		data.put("total", count);
		data.put("rows", list_1);

		return data;
	}

	private StringBuffer getCond(Map map_1) {
		StringBuffer sb = new StringBuffer();
		String target = (String) map_1.get("target");
		List<FormField> sfs = ContextManager.getPageByTarget(target).getQuerylist().getSearch_form().getFields();

		for (FormField sf : sfs) {
			String val = (String) map_1.get(sf.getField());
			if (StringUtils.isNotBlank(val)) {
				if (sb.length() == 0){
					sb.append(" where ");
					sb.append(sf.getField());
					if(StringUtils.isNotBlank(sf.getOp())){
						sb.append(sf.getOp()).append("'").append(val).append("'");
					}else{
						sb.append(" = '").append(val).append("'");
					}
				}else{
					sb.append(" and ").append(sf.getField()).append(" = '").append(val).append("'");
				}
				
			}
		}
		sb.append("  ");
		return sb;
	}

}
