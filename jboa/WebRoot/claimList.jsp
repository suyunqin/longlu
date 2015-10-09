<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'CaimList.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<div id="claimListToolbar">
		<a href="javascript:void(0);" id="claimListToolbar_Edit">编辑</a>&nbsp;&nbsp;
		<a href="javascript:void(0);" id="claimListToolbar_Del">删除</a>&nbsp;&nbsp;
		<a href="javascript:void(0);" id="claimListToolbar_weizhi">？？？</a>&nbsp;&nbsp;
		<a href="javascript:void(0);" id="claimListToolbar_ShowInfo">查看</a>
	</div>
	<table id="claimList"></table>
</body>
</html>
