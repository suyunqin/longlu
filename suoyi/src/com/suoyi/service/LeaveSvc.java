package com.suoyi.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.suoyi.entity.Leave;
import com.suoyi.entity.UserBean;
import com.suoyi.util.SessionUtil;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class LeaveSvc extends BaseServiceImpl {
	
    @Override
	public void add(Map map_1) throws Exception {
	    
		UserBean user = (UserBean) map_1.get("user");
		map_1.put("nextopid", String.valueOf(user.getId()));
		map_1.put("state", "1");
	    super.add(map_1);
	    Leave leave = (Leave) SessionUtil.getSession().load(Leave.class, new Long(map_1.get("pk").toString()));
	    leave.setCreatetime(new Date());
	    SessionUtil.beginTx();
	    SessionUtil.getSession().update(leave);
	    SessionUtil.commit();
	    
	}
    
    @Override
    public Map getData(Map map_1) throws Exception {
        return super.getData(map_1);
    }
}
