<%@page import="com.suoyi.sys.ContextManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>

<script type="text/javascript">
</script>

</head>
<body>
	<form id="form_addleave">
		<input type="hidden" name="action" value="<%=request.getParameter("action") %>" />
		<input type="hidden" name="hibean" value="<%=request.getParameter("hibean") %>"/>
		<input type="hidden" name="svc" value="<%=request.getParameter("svc") %>" />
		<table border="1">
			<thead>
				<th colspan="2" style="text-align: center;"><h3>新增请假单</h3></th>
			</thead>
			<tbody>
				<tr>
					<td class="td_label">申请人[自动]:</td>
					<td class="td_field"><input type="text" class="readonlyInput" readonly name="show_creater" value="<%=ContextManager.getCurUser(request).getName()%>"/>
					<input type="hidden" name="createid" value="<%=ContextManager.getCurUser(request).getId()%>"/>
					</td>
				</tr>
				<tr>
					<td class="td_label">开始时间:</td>
					<td class="td_field"><input class="easyui-datetimebox" name="starttime" data-options="showSeconds:false,required:true,editable:false"></td>
				</tr>
				<tr>
					<td class="td_label">结束时间:</td>
					<td class="td_field"><input class="easyui-datetimebox" name="endtime" data-options="showSeconds:false,required:true,editable:false"></td>
				</tr>
				<tr>
					<td class="td_label">请假缘由:</td>
					<td class="td_field"><textarea rows="3" cols="21" name="reason" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr style="text-align: center;"><td colspan="2"><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="submitForm()" id="a_submitbtn">&nbsp;提&nbsp;&nbsp;交&nbsp;</a></td></tr>
			</tfoot>
		</table>
	</form>
</body>
</html>