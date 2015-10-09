WINDOW_HEIGHT = window.innerHeight;
WINDOW_WIDTH = window.innerWidth;
$(function() {
	isLogin();
	$("input[name='msg']").hide();
	$("#login").dialog({
		iconCls : 'icon-edit',
		title : 'Please login first！',
		width : 350,
		height : 160,
		top : 100,
		closable : false,
		draggable : false,
		resizable : false,
		closed : true,
		buttons : [ {
			iconCls : 'icon-ok',
			text : '登录',
			handler : login
		} ]
	});

	$("#leftMenu").window({
		draggable : false,
		maximizable : false,
		minimizable : false,
		height : 300,
		left : WINDOW_WIDTH * 0.04,
		top : 160,
		title : '菜单栏',
		closable : false,
		width : 200,
		inline : true
	});

	$(".menuBtn_icon_look").linkbutton({
		iconCls : 'icon-search'
	});
	$(".menuBtn_icon_add").linkbutton({
		iconCls : 'icon-add'
	});

	$("#tabs").tabs({
		width : WINDOW_WIDTH * 0.75
	});
	addTab("报销单列表");
});

function addTab(title) {
	var tabs = $("#tabs");
	if (tabs.tabs('exists', title)) {
		tabs.tabs('select', title);
		return;
	}

	var href = "", onLoad = function() {
	}, onClose = function() {
	};

	if (title == "报销单列表") {
		href = 'claimList.jsp';
		onLoad = claimLoadSuccess;
	} else if (title == "更新报销单") {
		href = "editclaimInfo.jsp";
		onLoad = function() {
			$("#closeThisTab").linkbutton({
				iconCls : 'icon-undo',
				onClick : function() {
					$("#tabs").tabs('close', title);
				}
			});
		};
	} else if (title == "请假列表") {

	} else if (title == "请假申请") {

	} else if (title == "查看报销单") {
		href = "claimInfo.jsp";
		onLoad = function() {
			$("#closeThisTab").linkbutton({
				iconCls : 'icon-undo',
				onClick : function() {
					$("#tabs").tabs('close', title);
				}
			});
		};
		onClose = function(title, index) {
			alert("close >>" + title);
			$.get('clearClaimInfo');
		};
	}

	tabs.tabs('add', {
		title : title,
		closable : true,
		href : href,
		onLoad : onLoad,
		onClose : onClose
	});
}

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
			width : 20
		}, {
			field : 'total_account',
			title : '总金额',
			align : 'center',
			width : 15
		}, {
			field : 'status',
			title : '状态',
			align : 'center',
			width : 15
		}, {
			field : 'next_deal_name',
			title : '待处理人',
			align : 'center',
			width : 15
		} ] ],
		singleSelect : true,
		striped : true,
		loadMsg : '数据加载中。。。',
		rownumbers : true,
		fitColumns : true,
		pagination : true,
		pagePosition : 'bottom',
		// fit : true,
		pageSize : 15,
		pageList : [ 15, 30 ],
		method : 'post',
		onClickRow : click_row
	});
	create_datagrid_toolbar();
}

function click_row(index, rowData) {
	create_datagrid_toolbar();
	if (rowData != null) {
		if (rowData.status == "新创建") {
			$("#claimListToolbar_Edit").linkbutton({
				disabled : false
			});
			$("#claimListToolbar_Del").linkbutton({
				disabled : false
			});
		}
	} else
		$.messager.show({
			title : 'Msg',
			msg : '请先选择一个要编辑的报销单！',
			timeout : 1500
		});
}

function create_datagrid_toolbar() {
	$("#claimListToolbar_Edit").linkbutton({
		iconCls : 'icon-edit',
		disabled : true,
		onClick : edit_info
	});
	$("#claimListToolbar_Del").linkbutton({
		iconCls : 'icon-no',
		disabled : true
	});
	$("#claimListToolbar_weizhi").linkbutton({
		iconCls : 'icon-edit',
		disabled : true
	});
	$("#claimListToolbar_ShowInfo").linkbutton({
		iconCls : 'icon-search',
		onClick : show_info
	});
}

function edit_info() {
	var row = $("#claimList").datagrid('getSelected');
	if (row == null) {
		$.messager.show({
			title : 'Msg',
			msg : '请先选择一个要查看的报销单！',
			timeout : 1500
		});
		return;
	}
	$.post('getClaim', "claimID=" + row.id, function(data) {
		if (data || data == "true")
			addTab('更新报销单');
	});
}

function show_info() {
	var row = $("#claimList").datagrid('getSelected');
	if (row == null) {
		$.messager.show({
			title : 'Msg',
			msg : '请先选择一个要查看的报销单！',
			timeout : 1500
		});
		return;
	}
	$.post('getClaim', "claimID=" + row.id, function(data) {
		if (data || data == "true")
			addTab('查看报销单');
	});
}

function login() {
	$("#loginForm").form('submit', {
		url : 'login',
		onSubmit : function() {
			var username = $("input[name='empId']");
			if (username.val() == "") {
				username.val("请输入您的工号！");
				username.addClass("color_ccc");
				return false;
			}
			var password = $("input[name='password']");
			if (password.val() == "") {
				password.hide();
				var msgbox = $("input[name='msg']").val("请输入您的密码！");
				msgbox.addClass("color_ccc");
				msgbox.show();
				return false;
			}
		},
		success : function(date) {
			// alert(date);
			if (date || date == 'true') {
				location.replace(location.href, true);
			} else {
				$.messager.show({
					title : 'Msg',
					msg : '登录失败，请检查您的工号和密码！',
					timeout : 1500
				});
			}
		}
	});
}

function isLogin() {
	$.get('isLogin', function(date) {
		/**
		 * date 为true 代表服务器端session中不包含用户信息
		 */
		if (date || date == 'true') {
			$("#login").dialog({
				closed : true
			});
		} else {
			$("#login").dialog({
				closed : false
			});
			$("input[name='empId']").focus();
		}
	});
}

function clearIDMsg(obj) {
	if ($(obj).val() == "请输入您的工号！") {
		$(obj).removeClass("color_ccc");
		$(obj).val("");
	}
}

function replacePwdBox(obj) {
	$(obj).hide();
	$("input[name='password']").show();
	$("input[name='password']").focus();
}