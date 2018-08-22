<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 引入jstl标签库 -->
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- jqGrid组件基础样式包-必要 -->
		<link rel="stylesheet" href="${basePath}/jqgrid/css/ui.jqgrid.css" />
		
		<!-- jqGrid主题包-非必要 --> 
		<!-- 在jqgrid/css/css这个目录下还有其他的主题包，可以尝试更换看效果 -->
		<link rel="stylesheet" href="${basePath}/jqgrid/css/css/redmond/jquery-ui-1.8.16.custom.css" />

		<!-- jquery插件包-必要 -->
		<!-- 这个是所有jquery插件的基础，首先第一个引入 -->
		<script type="text/javascript" src="${basePath}/js/jquery-1.7.1.js"></script>
		
		<!-- jqGrid插件包-必要 -->
		<script type="text/javascript" src="${basePath}/jqgrid/js/jquery.jqGrid.src.js"></script>
		
		<!-- jqGrid插件的多语言包-非必要 -->
		<!-- 在jqgrid/js/i18n下还有其他的多语言包，可以尝试更换看效果 -->
		<script type="text/javascript" src="${basePath}/jqgrid/js/i18n/grid.locale-hr1250.js"></script>	
		<script type="text/javascript" src="${basePath}/js/index.js"></script>

<s	cript src="${basePath}/ttms/common/page.js"></script>
<div class="container">
   <!-- 页面导航 -->
    <div class="page-header">
		<div class="page-title" style="padding-bottom: 5px">
			<ol class="breadcrumb">
			  <li class="active" id="titleId">档案管理</li>
			</ol>
		</div>
	</div>
	<form method="post" id="userFormHead">
	    <!-- 查询表单 -->
		<div class="row page-search">
		 <div class="col-md-12">
			<ul class="list-unstyled list-inline">
				<li><input type="text" id="userName" class="form-control" placeholder="用户名"></li>
				<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
				<li class='O2'><button type="button" class="btn btn-primary btn-add">新增</button></li>
				<li class='O3'><button type="button" class="btn btn-primary btn-update">修改</button></li>
			</ul>
		  </div>
		</div>
		<!-- 列表显示内容 -->
		<div class="row col-md-12">
			<table class="table table-bordered" id="userTable">
				
				
					<div id="tbody"></div>
				
			</table>
			<%@include file="page.jsp" %>
		</div>
	</form>
</div>
<!--  
<script type="text/javascript" src="${basePath}/ttms/system/user_list.js"></script>
-->
<script type="text/javascript">
$(function(){
	//页面加载完成之后执行
	pageInit();
});
function pageInit(){
	//创建jqGrid组件
	jQuery("#userTable").jqGrid(
			{
				
				url : 'show.do',//组件创建完成之后请求数据的url
				datatype : "json",//请求数据返回的类型。可选json,xml,txt
				jsonReader : {
					root:"rows",
					page: "page",
					total: "totalPage",
					records: "total",
					id:"id"
				},
				height : '60%',
				colNames : [ '选择', '用户名', '邮箱', '手机号', '状态','操作' ],//jqGrid的列显示名字
				colModel : [ //jqGrid每一列的配置信息。包括名字，索引，宽度,对齐方式.....
				             {name : 'id',index : 'id',width : 55}, 
				             {name : 'username',index : 'username',width : 90}, 
				             {name : 'email',index : 'email',width : 100}, 
				             {name : 'mobile',index : 'mobile',width : 80,align : "right"}, 
				             {name : 'state',index : 'state',width : 80,align : "right"}, 
				             {name : 'stateStr',index : '',width : 80,align : "right"}, 
				            
				           ],
				rowNum : 10,//一页显示多少条
				rowList : [ 10, 20, 30 ],//可供用户选择一页显示多少条
				pager : '#tbody',//表格页脚的占位符(一般是div)的id
				sortname : 'id',//初始化的时候排序的字段
				sortorder : "desc",//排序方式,可选desc,asc
				loadComplete : function() {
					var table = this;
					setTimeout(function() {
						//加载分页
						initPagingBar("#userTable");
					}, 0);
				},
				mtype : "get",//向后台请求数据的ajax的类型。可选post,get
				viewrecords : true,
				caption : "登记主表"//表格的标题名字
			});
	/*创建jqGrid的操作按钮容器*/
	/*可以控制界面上增删改查的按钮是否显示*/
	jQuery("#userTable").jqGrid('navGrid', '#tbody', {edit : true,add : true,del : true});
}
</script>