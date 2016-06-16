<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/register.css">
<title>注册</title>
</head>

<body>
	<div class="tittle">My Blog</div>
	<div class="register-box">
    	<div class="head"><h2>注册</h2></div>
    	<span style="padding-left:60px; color:red;">
        <% if(request.getSession().getAttribute("Info")!=null){
        	out.print(request.getSession().getAttribute("Info"));
        }
      
        %>
       </span>
        <form action="/Myblock/RegisterSer" method="post">
        <div class="list">
        <ul>
        	<li>
            	<div class="label">
                	<span class="required">*</span>
                    用户名:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="name"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    密码:
                </div>
                <div class="text">
                	<input class="inptxt" type="password" name="password1"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    确认密码:
                </div>
                <div class="text">
                	<input class="inptxt" type="password" name="password2"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    年龄:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="age"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    生日:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="birth"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    性别:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="sex"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    语言:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="lan"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    星座:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="zodiac"  /> 
                </div>
            </li>
           	<li>
            	<div class="label">
                	<span class="required">*</span>
                    地址:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="address"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    邮件:
                </div>
                <div class="text">
                	<input class="inptxt" type="email" name="email"  /> 
                </div>
            </li>
            <li>
            	<div class="label">
                	<span class="required">*</span>
                    个人介绍:
                </div>
                <div class="text">
                	<input class="inptxt" type="text" name="note"  /> 
                </div>
            </li>
        </ul>
        	<div class="submit">
        	<button class="b_submit"  tabindex="5px" data-img="确认中" type="submit">注册</button>
       		</div>
        </div>
        </form>
    </div>
</body>
</html>
