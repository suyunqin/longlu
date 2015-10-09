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
	make_validatebox();
	$("#tabs").tabs({
		width : WINDOW_WIDTH * 0.75
	});
	addTab("报销单列表");
	addTab("查看报销单");
});

function make_validatebox() {
	$("input[name='empId']").validatebox({
		required : true,
		missingMessage : '请输入您的工号！'
	});
	$("input[name='password']").validatebox({
		required : true,
		missingMessage : '请输入您的密码！'
	});
}

function addTab(createTitle) {
	var tabs = $("#tabs");
	if (tabs.tabs('exists', createTitle)) {
		tabs.tabs('select', createTitle);
		return;
	}

	var href = "", load_success = function() {
	};

	if (createTitle == "报销单列表") {
		href = 'claimList.jsp';
		load_success = claimLoadSuccess;
	} else if (createTitle == "更新报销单") {
		href = "editclaimInfo.jsp";
		load_success = function() {
			close_thisTab(createTitle);
		};
	} else if (createTitle == "请假列表") {

	} else if (createTitle == "请假申请") {

	} else if (createTitle == "查看报销单") {
		href = "claimInfo.jsp";
		load_success = function() {
			close_thisTab(createTitle);
		};
	}

	function close_thisTab(title) {
		$("#closeThisTab").linkbutton({
			iconCls : 'icon-undo',
			width : 150,
			onClick : function() {
				$("#tabs").tabs('close', title);
			}
		});
	}
	;

	/**
	 * esayui这个位置可能存在bug onClose事件，onBeforeClose事件都会在取消选择的时候被调用 而不是关闭后和关闭前
	 * onUnselect事件不会被调用
	 */
	tabs.tabs('add', {
		title : createTitle,
		closable : true,
		href : href,
		onLoad : load_success
	});
}

function login() {
	var login_form = $("#loginForm");
	login_form.form('submit', {
		url : 'login',
		onSubmit : function() {
			// alert(login_form.form('validate'));
			return login_form.form('validate');
		},
		success : function(date) {
			if (date == 'true') {
				// alert(date);
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

// function clearIDMsg(obj) {
// if ($(obj).val() == "请输入您的工号！") {
// $(obj).removeClass("color_ccc");
// $(obj).val("");
// }
// }
//
// function addIDMsg(obj) {
// var $obj = $(obj);
// if ($obj.val() == "" || $obj.val() == "请输入您的工号！") {
// $obj.val("请输入您的工号！");
// $obj.addClass("color_ccc");
// return false;
// }
// return true;
// }
//
// function replacePwdBox(obj) {
// $(obj).hide();
// $("input[name='password']").show();
// $("input[name='password']").focus();
// }
//
// function addPwdMsg(obj) {
// var $obj = $(obj);
// if ($obj.val() == "") {
// $obj.hide();
// var msgbox = $("input[name='msg']").val("请输入您的密码！");
// msgbox.addClass("color_ccc");
// msgbox.show();
// return false;
// }
// return true;
// }
