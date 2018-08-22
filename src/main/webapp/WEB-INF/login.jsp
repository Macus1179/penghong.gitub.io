<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<html>
	<head>
		<title>登录</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="../css/style.css" />
		<script type="text/javascript">
			function f1(){
				var asd = document.getElementById("asd");
				asd.src="${pageContext.request.contextPath}/checkcode?id="+Math.random()
			}
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								<%=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) %>
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						登录
					</h1>
					<form action="loginUser.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
									<% String msg=(String)request.getAttribute("user_error");
                                    %>
									<span style="font-size:25px;color:red">
                                      <%=(msg==null? "":msg)%></span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
								<tr>
								<td valign="middle" align="right">
									验证码:
								</td>		<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" />
									<img id="asd" alt="" src="${pageContext.request.contextPath}checkcode"
										onclick="this.src='${pageContext.request.contextPath}checkcode?'+Math.random()">
										<input type="button" value="更换" onclick="f1();">									
										<%
											String msg2=(String)request.getAttribute("number_error");
											
										%>
										<span style="color:red;font-size:25px;">
											<%=(msg2==null? "":msg2) %>
										</span>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确定" 
							onclick="location='list.do'"/>
							<%
                                        String errorMsg = (String)request.getAttribute("user_error");
                                    %>
                                    <span style="color:red;"><%=errorMsg==null?"":errorMsg%></span>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
