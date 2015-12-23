<%@page import="com.suoyi.ui.form.Form"%>
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
	String formid = null;
	boolean isQueryForm = false;
%>
<body>
	<%
	PageModel target_page = ContextManager.getPageByTarget(target);
	
	if(target_page==null){
	%>
		<iframe src="jsp/nopage_error.jsp"></iframe>
	<%
	}
	Form form = null;
	Map valueMap = null;
	if(target_page.getType().equals("ql")){
		QueryList ql = target_page.getQuerylist();
		form = ql.getSearch_form();
		isQueryForm = true;
		valueMap = (Map)request.getAttribute("search_map");
	}else if(target_page.getType().equals("form")){
		formid = (String)request.getParameter("formid");
		form = target_page.getFormById(formid);
		valueMap = (Map)request.getAttribute("valueMap");
	}
	 
	%>
	<form action="action.do" id="form_<%=page_id%>">
		<div class="div_form">
			
			<%
				if(isQueryForm){
			%>
			<p class="p_search_form_title">查&nbsp;询&nbsp;参&nbsp;数</p>
			<%
				}else{
			%>	
					<div>&nbsp;</div>
			<%
				}
			 %>
			<input type="hidden" name="target" value="<%=target%>"/>
			<%
				for (int i = 0;i<form.getFields().size();i++) {
						FormField sf = form.getFields().get(i);
						if("text".equals(sf.getType())){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<input name="<%=sf.getField()%>" type="<%=sf.getType() %>" <%=sf.getIsRead()==null?"":"readonly class=\"readonlyInput\"" %> value="<%
							Object value = valueMap.get(sf.getField());
							if(value!=null){out.print(value);}
						%>" />&nbsp;
			<%
					}else if("date".equals(sf.getType())){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<input name="<%=sf.getField()%>" id="input_<%=sf.getField() %>_<%=page_id %>" class="easyui-datebox" data-options="editable:false<%=sf.getIsRead()==null?"":",\"readonly:true\"" %>" value="<%
							Object value = valueMap.get(sf.getField());
							if(value!=null){out.print(value);}
						%>"/> <img alt="清空" onclick="doClear('<%=sf.getField() %>','<%=page_id%>')" src="images/clear_16.png" align="middle">&nbsp;
			<%
					}else if("datetime".equals(sf.getType())){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<input name="<%=sf.getField()%>" id="input_<%=sf.getField() %>_<%=page_id %>" class="easyui-datetimebox" data-options="editable:false<%=sf.getIsRead()==null?"":",\"readonly:true\"" %>" value="<%
							Object value = valueMap.get(sf.getField());
							if(value!=null){out.print(value);}
						%>"/> <img alt="清空" onclick="doClear('<%=sf.getField() %>','<%=page_id%>')" src="images/clear_16.png" align="middle">&nbsp;
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
									Object value = valueMap.get(sf.getField());
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
					}else if(sf.getType().equals("textarea")){
			%>
						<label for="<%=sf.getField()%>"><%=sf.getLabel() %>：</label>
						<textarea name="<%=sf.getField()%>" rows="3" cols="21" <%=sf.getIsRead()==null?"":"readonly class=\"readonlyInput\"" %> ><%
							Object value = valueMap.get(sf.getField());
							if(value!=null){out.print(value);}
						%></textarea>&nbsp;
			<%			
					}
						
					if(i!=0&&((i+1)%3==0||i==3)){
			%>		
						<div style="height:5px;"></div>
			<%		
					}
				}
				if(isQueryForm){
			%>
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doQuery(<%=page_id%>,1,15,<%=target%>)">&nbsp;查&nbsp;询&nbsp;</a>
			<%
				}else{
			%>
					<div class="div_formbtn_con"><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="doSubmitForm(<%=page_id%>,<%=target%>,<%=formid%>)"><%=request.getAttribute("btnlabel") %></a></div>
			<%
				}
			%>
		</div>
	</form>
</body>
</html>