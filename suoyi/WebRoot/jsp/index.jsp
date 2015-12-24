<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.suoyi.ui.Button"%>
<%@page import="com.suoyi.ui.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.suoyi.sys.ContextManager"%>
<% String ctx = ContextManager.context.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="include.jsp">
	<jsp:param value="<%=ctx %>" name="ctx"/>
</jsp:include>
<title>index</title>
<style type="text/css">
body {
	padding: 0px;
	margin: 0px;
}

#div_top {
	padding: 5px;
	padding-left: 15px;
}

/*.menu_btn {
	font-size: 15px;
	font-weight: bold;
	padding: 5px;
	background-color: #BBBCCC;
	margin: 5px;
	border: 2px solid #BCBCBC;
	-moz-border-radius: 18px; 
	-webkit-border-radius: 18px; 
	border-radius: 18px;
}*/
.menu_btn {
	font-size: 15px;
	font-weight: bold;
	padding: 5px;
	color: #333;
	margin: 5px;
	background: #b8eecf;
	background: -webkit-linear-gradient(top, #b8eecf 0, #a4e9c1 100%);
	background: -moz-linear-gradient(top, #b8eecf 0, #a4e9c1 100%);
	background: -o-linear-gradient(top, #b8eecf 0, #a4e9c1 100%);
	background: linear-gradient(to bottom, #b8eecf 0, #a4e9c1 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#b8eecf,
		endColorstr=#a4e9c1, GradientType=0);
	border: 2px solid #BCBCBC;
	-moz-border-radius: 18px;
	-webkit-border-radius: 18px;
	border-radius: 18px;
}

.menu_btn:hover {
	background-color: #CCC;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	$(function() {

		$("#div_top").panel({
			height : 93
		});

		$("#div_left").panel({
			width : 120,
			height : window_height - 70
		});
		
		getWeather();
		
	});

	function doMenu(id,name,href) {
		if($("#div_tabs_index").tabs('exists',name)){
			$("#div_tabs_index").tabs('select',name);
			return;
		}
		$("#div_tabs_index").tabs('add',{
			id:id,
			title:name,
			href:href,
			closable:true,
			onLoad:function(){
				//alert($("#data-con").width());
				$(".data_grid").datagrid('fitColumns');
			}
		});
	}
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north'" style="height: 95px;"><jsp:include
			page="top.jsp"></jsp:include></div>   
    <div data-options="region:'east'" style="width:100px;"></div>   
    <div data-options="region:'west'" class="easyui-accordion" data-options=""
		style="width: 140px;">
		<%
			List<Menu> ls_menu = ContextManager.menu;
			for (Menu m : ls_menu) {
		%>
		<div class="div_menu_btn_con" style="text-align: center;"
			title="<%=m.getName()%>">
			<%
				List<Button> btns = m.getBtns();
						for (Button btn : btns) {
			%>
			<div class="menu_btn" onclick="<%=btn.getOnclick()%>"><%=btn.getName()%></div>
			<%
				}
			%>
		</div>
		<%
			}
		%>
		<!-- </div> -->
	</div>   
    <div data-options="region:'center'" id="div_tabs_index" class="easyui-tabs">
		<div title="我的桌面" id="myDeskTop" style="padding: 20px;"></div>
	</div>   
</body>  
<%-- <body class="easyui-layout">
	<div data-options="region:'north'" style="height: 95px;"><jsp:include
			page="top.jsp"></jsp:include></div>
	<div data-options="region:'west'" class="easyui-accordion" data-options=""
		style="width: 140px;">
		<%
			List<Menu> ls_menu = ContextManager.menu;
			for (Menu m : ls_menu) {
		%>
		<div class="div_menu_btn_con" style="text-align: center;"
			title="<%=m.getName()%>">
			<%
				List<Button> btns = m.getBtns();
						for (Button btn : btns) {
			%>
			<div class="menu_btn" onclick="<%=btn.getOnclick()%>"><%=btn.getName()%></div>
			<%
				}
			%>
		</div>
		<%
			}
		%>
		<!-- </div> -->
	</div>
	<div data-options="region:'center'" id="div_tabs_index" class="easyui-tabs">
		<div title="我的桌面" id="myDeskTop" style="padding: 20px;"></div>
	</div>
</body> --%>
</html>