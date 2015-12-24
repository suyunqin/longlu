<%@page import="com.suoyi.util.ReplaceParam"%>
<%@page import="com.suoyi.ui.qlist.TdBtn"%>
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
<%@page import="com.suoyi.ui.form.FormField"%>
<%@page import="com.suoyi.ui.qlist.QueryList"%>
<%@page import="com.suoyi.ui.PageModel"%>
<%@page import="org.apache.commons.beanutils.NestedNullException" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<%
	String target = (String) request.getParameter("target");
	String page_id = String.valueOf(System.currentTimeMillis());
	Map datas = (Map) request.getAttribute("datas");
	Map map_1 =  (Map)request.getAttribute("map_1");
	PageBean pageB = (PageBean)map_1.get("pageB");
%>
<body id="body_<%=page_id%>">
	<%
			PageModel target_page = ContextManager.getPageByTarget(target);
			if(target_page==null){
	%>	
		<%-- <h3 class="h3_notfound">404 Not Found - - - SUOYI APP EXECPTION</h3><br />
		<font class="font_error_msg">模块异常:&nbsp;PageModel[-&nbsp;<font color="red" style="font-weight: bold;"><%=target%></font>&nbsp;-]&nbsp;未定义!</font> --%>
		<iframe src="jsp/nopage_error.jsp" scrolling="no" class="inc_iframe"></iframe>
	<%
				return;
			}
			QueryList ql = target_page.getQuerylist();
			List<FormField> sfs = ql.getSearch_form().getFields();
			List<ContentTD> tds = ql.getContent().getContent();
			Map search_map = (Map)request.getAttribute("search_map");
	%>
	<jsp:include page="form.jsp">
		<jsp:param value="<%=target %>" name="target"/>
		<jsp:param value="<%=page_id %>" name="page_id"/>
		<jsp:param value="queryForm" name="action"/>
	</jsp:include>
	<%-- <iframe scrolling="no" class="inc_iframe" src="form.do?action=queryForm&target=<%=target%>&page_id=<%=page_id%>"></iframe> --%>
	<table id="table_data_<%=page_id%>" style="width: 95%;margin: 0px auto;" cellpadding="0" cellspacing="0">
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
						StringBuffer str_td = new StringBuffer("<td class=\"td_data_grid\">");
						if(td.getType().equals("btn")){
							StringBuffer sb_btn = new StringBuffer();
							for(TdBtn btn:td.getBtns()){
								if(sb_btn.length()!=0)sb_btn.append(" ");
								sb_btn.append("<a href=\"javascropt:void(0);\"").append(" onclick=\"doOpenWindow('");
								String href = null;
								if(btn.getHref()!=null){
									href = ReplaceParam.replaceHrefByBean(btn.getHref(), obj);
								}
								if(href!=null){
									sb_btn.append(href);
								}
								sb_btn.append("','").append(new Date().getTime());
								sb_btn.append("')\">").append(btn.getText());
								sb_btn.append("</a>");
							}
							str_td.append(sb_btn);
						}else{
							Object obj_td = null;
							try{
								obj_td = PropertyUtils.getProperty(obj,td.getField());
							}catch(NestedNullException e){
							}
							
							if(obj_td!=null){
								if(td.getType().equals("date")){
									str_td.append(DateHandler.sdf.format((Date)obj_td));
								}else if(td.getType().equals("datetime")){
									str_td.append(DateHandler.sdf_noss.format((Date)obj_td));
								}else if(td.getType().startsWith("list_")){
									str_td.append(ContextManager.getDictNameByTypeAId(td.getType().split("_")[1], obj_td.toString()));
								}else{
									str_td.append(obj_td);
								}
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