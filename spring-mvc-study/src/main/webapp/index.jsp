<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'test2.jsp' starting page</title>

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
	<h2>
		<a href="hello/mvc">Hello World!</a>
	</h2>
	<hr />
	<form action="hello/inputtest" method="post">
		<label for="id">学生ID</label><input type="text" id="id" name="id" /><label
			for="name">学生姓名</label><input type="text" id="name" name="name" /> <input
			type="submit" value="提交" />
	</form>
	<hr />
	<form action="hello/doUpload" method="post"
		enctype="multipart/form-data">
		<label for="file">请选择文件</label><input type="file" name="file" /> <input
			type="submit" value="上传" />
	</form>
	<hr />
	<a href="hello/download">下载个人简历</a>
	<hr />
	<a href="hello/getJson">获取JSON</a>
</body>
</html>
