<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  	
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<title>登录</title>
  </head> 
  <body>
  	<div class="tittle">My Blog </div>
  	<form action="/Myblock/LoginSer" method="post">
    <div class="login-box">
    	<div class="head">
        <h2>登录</h2>
        </div>
        <br/><span style="padding-left:60px; color:red;">
        <% if(request.getSession().getAttribute("Info")!=null){
        	out.print(request.getSession().getAttribute("Info"));
        }
      
        %>
       </span>
        <div class="">
        账号：
        <input class="login" type="text" name="name"><br/><br/>
        <input class="login" type="password" name="password">
        密码：
        <br/>
        	<div class="login-links">
            <a class="register" target="_blank" href="register.jsp">免费注册</a>
            </div>
        </div>
        <div class="submit">
        <button class="b_submit"  tabindex="5px" data-img="确认中" type="submit">登录</button>
        </div>     
    </div>
   </form>
   
  </body>
</html>
