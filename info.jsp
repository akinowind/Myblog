<%@ page import="pojo.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>填写个人信息</title>
<link rel="stylesheet" style type="text/css" href="css/info.css">
</head>

<body>
<div class="top">
	<div class="ph_photo" node-type="photo">
    	<p class="photo_wrap">
    	<a href="">  
        <img class="image" src="img/20130310195946_Ccnma.thumb.600_0.jpeg">
        </a>
        </p>
    </div>
	<div class="ph_username">
    <span class="username">
    <% 
      if(request.getSession().getAttribute("name")!=null){
        	out.print(request.getSession().getAttribute("name"));
        } 
    %>
    
    </span>
    
    </div>
</div>
<div class="dbody">
	<form class="message" action="/Myblock/InfoSer" method="post">
	<%
		ArrayList wordlist=(ArrayList)session.getAttribute("wordlist");
		if(wordlist==null||wordlist.size()==0){
			response.sendRedirect("");
		}else{
			for(int i=wordlist.size()-1;i>=0;i--){
			
			User user=(User)wordlist.get(i);
		
	 %>
    	<div class="change-box">
    	<div class="head">
        <h2>修改信息</h2>
        </div>
        <br/>
        <div class="">
       	
       	 年龄:<input class="change" type="text" name="age" value="<%=user.getAge()%>"><br/><br/>
     	   生日:<input class="change" type="text" name="birth" value="<%=user.getBirth() %>"><br/><br/>
 		 性别:<input class="change" type="text" name="sex" value="<%=user.getSex() %>"><br/><br/>
 		  语言:<input class="change" type="text" name="lan" value="<%=user.getLan() %>"><br/><br/>
 		   星座:<input class="change" type="text" name="zodiac" value="<%=user.getZodiac() %>"><br/><br/>
 		  地址:<input class="change" type="text" name="address" value="<%=user.getAddress() %>"><br/><br/>
 		email:<input class="change" type="email" name="email" value="<%=user.getEmail() %>"><br/><br/>
 		个人说明:<textarea class="change" cols="20px" rows="4" name="note"><%=user.getNote() %></textarea>
        </div><br/>
        <div class="submit">       
        <button class="b_submit"  tabindex="5px" data-img="确认中" type="submit">确认修改</button>     
     
        </div>
    </div>
    <%
    	}
    }
     %>
    </form>
</div>
</body>
</html>
