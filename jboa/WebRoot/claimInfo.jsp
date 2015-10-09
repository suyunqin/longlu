<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body style="padding: 30px;">
	<div style="padding: 0px 50px 50px 25px;">
		<br />
		<table class="claim_info">
			<thead>
				<tr>
					<td colspan="4" style="line-height: 30px;"><h3>基本信息</h3></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>编&nbsp;号:&nbsp;<span id="claim_id"></span></td>
					<td>填 写 人:&nbsp;<span id="claim_create_name"></span></td>
					<td>部&nbsp;门:&nbsp;<span id="claim_dept_name"></span></td>
					<td>职&nbsp;&nbsp;位:&nbsp;<span id="claim_position_name"></span>
					</td>
				</tr>
				<tr>
					<td>总金额:&nbsp;<span id="claim_total_account"></span>
					</td>
					<td>填报时间:&nbsp;<span id="claim_create_time"></span>
					</td>
					<td>状&nbsp;态:&nbsp;<span id="claim_status"></span>
					</td>
					<td>待处理人:&nbsp;<span id="claim_next_deal_sn"></span>
					</td>
				</tr>
			</tbody>
		</table>
		<hr />
		<br /> <br />

		<table class="claim_info">
			<thead>
				<tr>
					<td>项目类别</td>
					<td>项目金额</td>
					<td>费用说明</td>
				</tr>
			</thead>
			<tbody id="claim_detail_list"></tbody>
		</table>
		<hr />
		<br /> <a href="javascript:void(0)" id="closeThisTab">返&nbsp;&nbsp;&nbsp;回</a>
	</div>
</body>
</html>
