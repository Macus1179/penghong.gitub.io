<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page pageEncoding="utf-8"  contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>注册</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
			<script type="text/javascript">
			function f1(){				
				var num = document.getElementById("num");
				console.log(1);
				num.src="${pageContext.request.contextPath}/checkcode?id="+Math.random()
			}
			function getId(ObjectId){
				return document.getElementById(ObjectId);
			}
			function checkUsername(){
				 console.log(1);
				 var xhr =new XMLHttpRequest();
				 var usernmae =getId("username").value;
				 var url ="check_username.do?username="+username;
				 xhr.onreadystatechange=function(){
					 if(xhr.readyState==4&&xhr.status==200){
						 //将响应正文的字符串转换成json对象
						 var jsonObj=JSON.parse(xhr.responseText);
						 if(jsonObj.state==1){
								getId("username_hint").style.color
								= "#FF0000";
						} else {
							getId("username_hint").style.color
								= "#0000FF";
						}
						 getId("username_hint").innerHTML=jsonObj.message;
						 console.log(jsonObj.message)
					 }
				 };
					xhr.open("GET", url, true);
					xhr.send();
			 }
		
		</script>
		
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="head.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册	
					</h1>
					<form action="register.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0" 
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri"
									 name="username"  id="username" onblur="checkUsername()"/>
									
                                    <span style="font-size:25px;color:red" id="username_hint" >
                                    		请输入昵称
                                     </span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									真实姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" 
									name="gender" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" 
									name="gender" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="${pageContext.request.contextPath}/checkcode" 
									onclick ="this.src='checkcode?'+math.random" name="num"/>
									<input type="button" value="更换" onclick="f1();">
									
										<span style="color:red;font-size:25px;" >
										
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="number" onblur="check()"/>
									<span style="color:red;font-size:25px;" id="check" >
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="注册" 
							/>
						</p>
					</form>
				</div>
			</div>
			<%@include file ="foot.jsp" %>
		</div>
	</body>
</html>
