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

<body>
	<table style="width: 100%;">
		<tr>
			<td colspan="4">基本信息</td>
		</tr>
		<tr>
			<td>编号：${sessionScope.claim.id }</td>
			<td>填写人：${sessionScope.claim.employeeByCreateSn.name }</td>
			<td>部门：${sessionScope.claim.employeeByCreateSn.department.name }</td>
			<td>职位：${sessionScope.claim.employeeByCreateSn.position.nameCn }</td>
		</tr>
		<tr>
			<td>总金额：${sessionScope.claim.totalAccount }</td>
			<td>填报时间：<fmt:formatDate
					value="${sessionScope.claim.createTime}"
					pattern="yyyy-MM-dd hh:mm:ss" />
			</td>
			<td>状态：${sessionScope.claim.status }</td>
			<td>待处理人：${sessionScope.claim.employeeByNextDealSn.name }</td>
		</tr>

		<!-- 
				Date date = ((ClaimVoucher) session.getAttribute("claim"))
						.getCreateTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss");
				out.write(sdf.format(date));
			 -->
	</table>
	<br />
	<hr />
	<br />
	<table style="width: 100%;margin-bottom: 15px;">
		<tr>
			<td>项目类型</td>
			<td>项目金额</td>
			<td>费用说明</td>
		</tr>
		<c:forEach var="detail"
			items="${sessionScope.claim.claimVoucherDetails}">
			<tr>
				<td><c:out value="${detail.item }"></c:out>
				</td>
				<td><c:out value="${detail.account }"></c:out>
				</td>
				<td><c:out value="${detail.des }"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>
	<hr />
	<br />
	<br />
	<div style="padding: 0px 0px 50px 25px;">
		<a href="javascript:void(0)" id="closeThisTab">返回</a>
	</div>
</body>
</html>
