<%@page import="com.suoyi.entity.UserBean"%>
<%@page import="com.suoyi.sys.ContextManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>top</title>
<style type="text/css">
a {
	text-decoration: none;
	font-size: 14px;
}

a:hover {
	color: red;
}

#div_login_info {
	float: right;
	font-size: 12px;
	margin-right: 30px;
}

#weather_info {
	float: right;
	margin: 0px 30px 0px 0px;
}
</style>
<script type="text/javascript">
	function getWeather() {

		var url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101210101";

		var xhr = false;
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e2) {
				xhr = false;
			}
		}

		if (!xhr && typeof XMLHttpRequest != 'undefined') {
			xhr = new XMLHttpRequest();
		}

		xhr.open("GET", url, true);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				var response = xhr.responseText;
				var weather = JSON.parse(response);
				var today = weather.data.forecast["0"];
				$("#city_name").html(weather.data.city);
				$("#maxC").html(today.high);
				$("#minC").html(today.low);
				$("#weather_desc").html(weather.data.ganmao);
				$("#nowC").html("当前" + weather.data.wendu + "°C");
				$("#fengxiang").html(today.fengxiang);
				$("#type").html(today.type);
			}
		}
		xhr.send();
	}
</script>
</head>
<body id="body_window_con">
	<%
		UserBean user = ContextManager.getCurUser(request);
	%>
	<div id="div_top">
		<img alt="slh" src="images/bdqn_logo.jpg">
		<div id="div_login_info">
			欢迎您：[<font color="red"><%=user.getName()%></font>]<br />工号：[<%=user.getSn()%>] 
			部门：[<%=user.getDept().getName()%>]<br /> <br /> <a href="deLogin.do">重新登录</a>
		</div>
		<div id="weather_info">
			<table style="margin: 0px;" width="800">
				<tbody>
					<tr>
						<td colspan="4" style="text-align: center; padding: 5px;">
						<font color="red" id="city_name"></font>&nbsp;今日天气</td>
					</tr>
					<tr>
						<td style="padding: 5px;">风向:<font id="fengxiang"></font></td>
						<td style="padding: 5px;">天气:<font id="type"></font></td>
						<td rowspan="2" style="text-align: justify;" id="weather_desc"></td>	
					</tr>
					<tr>
						<td style="padding: 5px; width: 200px;" colspan="2">
						温度:<font id="maxC"></font>&nbsp;<font id="minC"></font>
						<font id="nowC"></font></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>