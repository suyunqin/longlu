package com.suoyi.service.dao;

import java.util.Map;

@SuppressWarnings("rawtypes")
public interface BaseService {

	void preAdd(Map map_1) throws Exception;

	void add(Map map_1) throws Exception;

	void preEdit(Map map_1) throws Exception;

	void edit(Map map_1) throws Exception;

	Map getData(Map map_1) throws Exception;
	
}
