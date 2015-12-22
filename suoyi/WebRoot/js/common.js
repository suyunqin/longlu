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

//	$('#div_tabs_index').tabs('update', {
//		tab: tab,
//		options: {
//			title: '新标题',
//			content: 'http://www.baidu.com'  // 新内容的URL
//		}
//	});

	
	
	var params = {
			"action":'queryForm'
	};
	if(curPage!=''){
		params.curPage = curPage;
	}
	if(pageSize!=''){
		params.pageSize = pageSize;
	}
//
//	//$("#queryForm_"+page_id).submit();
//	
	$("#queryForm_"+page_id).form('submit',{
		url:'sys/action.do',
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