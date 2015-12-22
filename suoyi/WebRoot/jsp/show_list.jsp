<%@page import="com.suoyi.entity.sys.PageBean"%>
<%@page import="com.suoyi.util.DateHandler"%>
<%@page import="com.suoyi.sys.ContextManager"%>
<%@page import="com.suoyi.ui.qlist.ContentTD"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Map"%>
<%@page import="com.suoyi.entity.Dict" %>
<%@page import="com.suoyi.entity.sys.PageBean" %>
<%@page import="java.lang.StringBuffer" %>
<%@page import="com.suoyi.util.DateHandler" %>
<%@page import="org.apache.commons.beanutils.PropertyUtils" %>
<%@page import="com.suoyi.ui.qlist.SearchField"%>
<%@page import="com.suoyi.ui.qlist.QueryList"%>
<%@page import="com.suoyi.ui.PageModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<%
String page_id = String.valueOf(System.currentTimeMillis());
Map datas = (Map) request.getAttribute("datas");
Map map_1 =  (Map)request.getAttribute("map_1");
PageBean pageB = (PageBean)map_1.get("pageB");
%>
<body id="body_<%=page_id%>">
	<%
		String target = (String) request.getParameter("target");
		PageModel target_page = ContextManager.getPageByTarget(target);
		if(target_page==null){
	%>	
		<h3 class="h3_notfound">404 Not Found - - - SUOYI APP EXECPTION</h3><br />
		<font class="font_error_msg">模块异常:&nbsp;PageModel[-&nbsp;<font color="red" style="font-weight: bold;"><%=target %></font>&nbsp;-]&nbsp;未定义!</font>
	<%
			return;
		}
		QueryList ql = target_page.getQuerylist();
		List<SearchField> sfs = ql.getSearch();
		List<ContentTD> tds = ql.getContent();
		Map search_map = (Map)request.getAttribute("search_map");
	%>
	
	<form action="sys/action.do" id="queryForm_<%=page_id%>">
		<div class="div_search_form">
			<p class="p_search_form_title">查&nbsp;询&nbsp;参&nbsp;数</p>
			<input type="hidden" name="target" value="<%=search_map.get("target")%>"/>
			<%-- <input type="hidden" name="curPage" value="<%=pageB==null?1:pageB.getCurPage()%>">
			<input type="hidden" name="pageSize" value="<%=pageB==null?15:pageB.getPageSize()%>"> --%>
			<%
				for (int i = 0;i<sfs.size();i++) {
					SearchField sf = sfs.get(i);
					if("text".equals(sf.getType())){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<input name="<%=sf.getField()%>" type="<%=sf.getType() %>" <%=sf.getIsRead()==null?"":"readonly class=\"readonlyInput\"" %> value="<%
							Object value = search_map.get(sf.getField());
							if(value!=null){out.print(value);}
						%>" />&nbsp;
			<%
					}else if("date".equals(sf.getType())){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<input name="<%=sf.getField()%>" class="easyui-datebox" data-options="editable:false<%=sf.getIsRead()==null?"":",\"readonly:true\"" %>" value="<%
							Object value = search_map.get(sf.getField());
							if(value!=null){out.print(value);}
						%>"/>&nbsp;
			<%
					}else if("datetime".equals(sf.getType())){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<input name="<%=sf.getField()%>" class="easyui-datetimebox" data-options="editable:false<%=sf.getIsRead()==null?"":",\"readonly:true\"" %>" value="<%
							Object value = search_map.get(sf.getField());
							if(value!=null){out.print(value);}
						%>"/>&nbsp;
			<%
					}else if(sf.getType().startsWith("list")){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label> 
						<select class="easyui-combobox" data-options="editable:false,panelHeight:null" name="<%=sf.getField()%>" >
							<option>-全部-</option>
							<%
								String listid = sf.getType().split("_")[1];
								List<Dict> dicts = ContextManager.getDictbyType(listid);
								for(Dict dc:dicts){
							%>
							<option value="<%=dc.getSid()%>" <%
									Object value = search_map.get(sf.getField());
									if(value!=null)
									if(value.equals(dc.getSid()+"")){
										out.print("selected=\"selected\"");
									}
							%>><%=dc.getName() %></option>
							<%
								}
							%>
						</select>
			<%
					}
						
					if(i!=0&&((i+1)%4==0||i==3)){
			%>		
						<div style="height:5px;"></div>
			<%		
					}
				}
			%>
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doQuery(<%=page_id%>,1,15,<%=target%>)">&nbsp;查&nbsp;询&nbsp;</a>
		</div>
	</form>
	<table id="table_data_<%=page_id %>" style="width: 95%;margin: 0px auto;" cellpadding="0" cellspacing="0">
		<thead>
			<tr id="contentTitle">
				<td class="td_th" style="width:30px;">序号</td>
			<%
				for(ContentTD td:tds){
			%>
				<td class="td_th"><%=td.getName() %></td>
			<%				
				}
			%>
			</tr>
		</thead>
		<tbody id="tbody_datacontent_<%=page_id%>">
			<%
				List rows = (List)datas.get("rows");
				
				for(int i = 0;i<rows.size();i++){
					Object obj = rows.get(i);
			%>
			<tr class="tr_data_grid">
				<td class="td_data_grid"><%=i+1 %></td>
			<%
					for (ContentTD td : tds) {
						Object obj_td = PropertyUtils.getProperty(obj,td.getField());
						StringBuffer str_td = new StringBuffer("<td class=\"td_data_grid\">");
						
						if(obj_td!=null){
							if(td.getType().equals("date")){
								str_td.append(DateHandler.sdf.format((Date)obj_td));
							}else if(td.getType().equals("datetime")){
								str_td.append(DateHandler.sdf_noss.format((Date)obj_td));
							}else{
								str_td.append(obj_td);
							}
						}
						str_td.append("</td>");
						out.print(str_td.toString());
					}
			%>
			 </tr>
			<%	
				}
			%>
		</tbody>
	</table>
	<div class="div_pagebar">
		<%
			if(pageB!=null){
		%>		
			<a href="javascript:void(0);" onclick="doQuery(<%=page_id%>,1,<%=pageB.getPageSize() %>,<%=target%>)">首页</a>
			<a href="javascript:void(0);" onclick="doQuery(<%=page_id%>,<%=pageB.getPrePage() %>,<%=pageB.getPageSize() %>,<%=target%>)">上一页</a>
			<a href="javascript:void(0)" onclick="jumpPage(<%=page_id%>,<%=pageB.getPageSize() %>,<%=target%>)">跳至</a> - <input type="text" id="targetpage_<%=page_id %>" class="easyui-numberbox" value="<%=pageB.getCurPage() %>" 
			data-options="min:1,max:<%=pageB.getMaxPageNo()%>,width:30,height:20"/>/<%=pageB.getMaxPageNo() %> - 页
			<a href="javascript:void(0);" onclick="doQuery(<%=page_id%>,<%=pageB.getNextPage() %>,<%=pageB.getPageSize() %>,<%=target%>)">下一页</a>
			<a href="javascript:void(0);" onclick="doQuery(<%=page_id%>,<%=pageB.getMaxPageNo() %>,<%=pageB.getPageSize() %>,<%=target%>)">尾页</a>
			<font>共 - <%=pageB.getCount() %> - 条记录</font>
		<%		
			}
		%>
	</div>
</body>
</html>