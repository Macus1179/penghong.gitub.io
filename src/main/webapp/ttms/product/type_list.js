var columns = [//定义了table的表头及每列元数据信息
{
field : 'selectItem',
radio : true
},
{
title : '分类id',
field : 'id',
visible : false,
align : 'center',//水平居中
valign : 'middle',//垂直居中
width : '80px'
},
{
title : '分类名称',
field : 'name',
align : 'center',
valign : 'middle',
sortable : true,
width : '180px'
},
{
title : '上级分类',
field : 'parentName',
align : 'center',
valign : 'middle',
sortable : true,
width : '180px'
},
{
title : '排序号',
field : 'sort',
align : 'center',
valign : 'middle',
sortable : true,
width : '100px'
}];
$(function(){
	$("#formHead")
	.on("click",".btn-delete",doDeleteObject)
	.on("click",".btn-add",doLoadEditPage)
	
	doGetObjects();
});

function doLoadEditPage(){
	var url="type/editUI.do";
	$(".content").load(url,function(){
		$("#pageTitle").html("添加分类")
	});
}
function doGetObjects(){
	var tableId="typeTable";//对他进行了封装会自动加#
	var url="type/doFindObjects.do";
	//TreeTable是在tree.table.js中定义的
	var table=new TreeTable(tableId,url,columns);
	//设置在哪一列上展开数结构(0表示第一列)
	table.setExpandColumn(2);
	//初始化table对象(底层会发起异步请求获得数据然后更新页面)
	table.init();
}

function doDeleteObject(){
	//1.获得选中的id值
	var id=getSelectedId();
	//2.根据id值删除分类信息
	var url="type/doDeleteObject.do"
	var params={"id":id}
	if(!id){
		alert("请先选择")
		return;
	}
	$.post(url,params,function(result){
		if(result.state==1){
			alert(result.message)
			doGetObjects();		
		}else{
			alert(result.message)
		}
	});
	
}
function getSelectedId(){
	//获取id
	var selections=
	$("#typeTable").bootstrapTreeTable("getSelections")//返回的是数组
	console.log(selections)
	if(selections.length==0)return;
		
	
	return selections[0].id;//选择下标为0的值
}