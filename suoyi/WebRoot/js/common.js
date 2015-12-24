window_width = window.innerWidth;
window_height = window.innerHeight;

function submitForm(){
	$("#form_addleave").form('submit',{
		url:'sys/form.do',
		novalidate:true,
		success:function(data){
			alert(data);
		}
	});
}

function doQuery(page_id,curPage,pageSize,target) {
	var tab = $("#div_tabs_index").tabs('getTab',target);
	var params = {
			"action":'queryForm'
	};
	if(curPage!=''){
		params.curPage = curPage;
	}
	if(pageSize!=''){
		params.pageSize = pageSize;
	}
	if(target!=''){
		params.target = target;
	}
	$("#form_"+page_id).form('submit',{
		url:'action.do',
		queryParams:params,
		ajax:false,
		success:function(data){
			$('#div_tabs_index').tabs('update', {
				tab: tab,
				options: {
					content: data
				}
			});
		}
	});
}

function jumpPage(page_id,pageSize,target) {
	var curPage = $("#targetpage_"+page_id).val();
	doQuery(page_id, curPage, pageSize, target);
}

function doClear(pageid,name) {
	$("#input_"+pageid+"_"+name).datebox('reset');
}

function doSubmitForm(pageid,target,formid) {
	$("#form_"+pageid).form('submit',{
		url:'submit.do',
		success:function(data){
			var Jdata = JSON.parse(data);
			if(Jdata.val){
				alert("操作成功!");
				doCloseWindos(Jdata.dialogid);
			}else{
				alert(Jdata.error);
			}
		}
	});
}

function doCloseWindos(dialogid) {
	$("#dialog_"+dialogid).window('close');
}

function doOpenWindow(href,dialogid) {
	$("#body_window_con").append("<div id=\"dialog_"+dialogid+"\"></div>");
	$("#dialog_"+dialogid).window({
		title:'新窗口',
		width:window_width*0.8,
		height:window_height*0.8,
		href:href+"&dialogid="+dialogid
	});
}