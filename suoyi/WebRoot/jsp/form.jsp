<%@page import="java.util.List"%>
<%@page import="com.suoyi.ui.qlist.QueryList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.suoyi.ui.PageModel" %>
<%@page import="com.suoyi.ui.form.FormField" %>
<%@page import="com.suoyi.sys.ContextManager" %>
<%@page import="com.suoyi.entity.Dict" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<%
	String target = (String)request.getParameter("target");
	String page_id = (String)request.getParameter("page_id");
	if(page_id==null){
		page_id = System.currentTimeMillis()+"";
	}
	String action = (String)request.getParameter("action");
%>
<body>
	<%
	PageModel target_page = ContextManager.getPageByTarget(target);
	
	if(target_page==null){
	%>
		<iframe src="jsp/nopage_error.jsp"></iframe>
	<%
	}
	
	QueryList ql = target_page.getQuerylist();
	List<FormField> sfs = ql.getSearch_form().getFields();
	Map search_map = (Map)request.getAttribute("search_map");
	%>
	<form action="action.do" id="queryForm_<%=page_id%>">
		<div class="div_search_form">
			<%
				if("queryForm".equals(action)){
			%>
			<p class="p_search_form_title">查&nbsp;询&nbsp;参&nbsp;数</p>
			<%
				}
			 %>
			<input type="hidden" name="target" value="<%=target%>"/>
			<%
				for (int i = 0;i<sfs.size();i++) {
						FormField sf = sfs.get(i);
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
</body>
</html>