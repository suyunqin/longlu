package com.suoyi.service;

import java.util.Date;
import java.util.Map;

import com.suoyi.entity.Emp;
import com.suoyi.entity.Leave;
import com.suoyi.entity.UserBean;
import com.suoyi.util.DateHandler;
import com.suoyi.util.SessionUtil;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LeaveSvc extends BaseServiceImpl {
	
    @Override
	public void add(Map map_1) throws Exception {
	    
		UserBean user = (UserBean) map_1.get("user");
		map_1.put("nextopid", String.valueOf(user.getId()));
		map_1.put("state", "1");
		map_1.put("createtime", DateHandler.sdf_noss.format(new Date()));
	    super.add(map_1);
	}
    
    @Override
    public Map getData(Map map_1) throws Exception {
        return super.getData(map_1);
    }
    
    @Override
    public void preAdd(Map map_1) throws Exception {
    	// TODO Auto-generated method stub
    	super.preAdd(map_1);
    	UserBean user = (UserBean) map_1.get("user");
    	Leave leave = (Leave) map_1.get("bean");
    	Emp emp = (Emp) SessionUtil.getSession().get(Emp.class, user.getId());
    	leave.setCreater(emp);
    	leave.setCreateid(new Long(user.getId()).intValue());
    }    			
}
