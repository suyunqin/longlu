
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Login</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="themes/default/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="css/index.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/index.js" charset="utf-8"></script>
<link rel="stylesheet" href="css/comm.css" type="text/css"></link>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<div id="topTitle">
		<span id="role">【登陆角色：${sessionScope.position }】</span>&nbsp;&nbsp;&nbsp;&nbsp;<span
			id="name">${sessionScope.user.name }</span> 你好！欢迎访问青鸟办公管理系统！
	</div>
	<div id="leftMenu">
		<a href="javascript:void(0)" class="menuBtn_icon_look"
			onClick="addTab('报销单列表')">报销单列表</a><br /> <br /> <a
			href="javascript:void(0)" class="menuBtn_icon_add"
			onClick="addTab('添加报销单')">添加报销单</a><br /> <br /> <a
			href="javascript:void(0)" class="menuBtn_icon_look"
			onClick="addTab('请假列表')">查看请假</a><br /> <br /> <a
			href="javascript:void(0)" class="menuBtn_icon_add"
			onClick="addTab('请假申请')">申请请假</a>
	</div>

	<div id="tabs"></div>

	<div id="login">
		<form id="loginForm" method="post">
			<table id="loginTBL">
				<tr>
					<td class="label">工号：</td>
					<td><input name="empId" type="text" onfocus="clearIDMsg(this)" />
					</td>
				</tr>
				<tr>
					<td class="label">密码：</td>
					<td><input name="password" type="password" /> <input
						name="msg" type="text" onfocus="replacePwdBox(this)" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
