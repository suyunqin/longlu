function claimLoadSuccess() {
	$("#claimList").datagrid({
		url : 'getClaimVouchers',
		columns : [ [ {
			field : 'id',
			title : '编号',
			align : 'center',
			width : 10
		}, {
			field : 'create_time',
			title : '填报日期',
			align : 'center',
			width : 50
		}, {
			field : 'create_name',
			title : '填报人',
			align : 'center',
		// width : 8
		}, {
			field : 'total_account',
			title : '总金额',
			align : 'center',
		// width : 8
		}, {
			field : 'status',
			title : '状态',
			align : 'center',
		// width : 8
		}, {
			field : 'next_deal_name',
			title : '待处理人',
			align : 'center',
		// width : 8
		}, {
			field : 'do_something',
			title : '操作',
			align : 'center',
			formatter : columsFormatter,
			width : 30
		} ] ],
		singleSelect : true,
		striped : true,
		loadMsg : '数据加载中。。。',
		rownumbers : true,
		fitColumns : true,
		pagination : true,
		pagePosition : 'bottom',
		// fit : true,
		pageSize : 10,
		pageList : [ 10, 20 ],
		method : 'post',
		// onClickRow : click_row,
		onLoadSuccess : function() {
			create_datagrid_toolbar();
			$(this).datagrid('fixRowHeight');
		}
	});
}

function columsFormatter(value, row, index) {
	var result = "<a href='javascript:void(0);' class='claimListToolbar_Edit'>编辑</a>&nbsp;"
			+ "<a href='javascript:void(0);' class='claimListToolbar_Del'>删除</a>&nbsp;"
			+ "<a href='javascript:void(0);' class='claimListToolbar_ShowInfo' onClick='show_info("
			+ row.id + ")'>查看</a>";
	return result;
}

function create_datagrid_toolbar() {
	$(".claimListToolbar_Edit").linkbutton({
		iconCls : 'icon-edit',
	// height : 20
	});
	$(".claimListToolbar_Del").linkbutton({
		iconCls : 'icon-no',
	// height : 20
	});
	// $("#claimListToolbar_weizhi").linkbutton({
	// iconCls : 'icon-edit',
	// disabled : true
	// });
	$(".claimListToolbar_ShowInfo").linkbutton({
		iconCls : 'icon-search',
	// height : 20
	});
}

function edit_info(id) {
	$.post('getClaim', "claimID=" + row.id, function(data) {
		if (data || data == "true")
			addTab('更新报销单');
	});
}

function show_info(id) {

	$.post('getClaim', "claimID=" + id, function(data) {
		if (data || data == "true")
			addTab('查看报销单');
	});
}