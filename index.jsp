<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" style type="text/css" href="css/index.css">
<title>My blog</title>
</head>

<body>

<a class="href" href="login.jsp">登录</a>
<a class="href" href="register.jsp">注册</a><br/>
<div class="top">
	<div class="ph_photo" node-type="photo">
    	<p class="photo_wrap">
    	<a href="">
        <br/><img class="image" src="img/20130310195946_Ccnma.thumb.600_0.jpeg">
        </a>
        </p>
    </div>
    <br/>
	<div class="ph_username">
    <span class="username">请登录</span>
    
    </div>
</div>

<div class="dbody">
	<div class="body_left">
    	<div class="left_inform">
        	<div class="head">
        		<div class="line">
            	<h3>My Blog</h3>
           	 	</div><br/>	
            </div>
            <a class="line" href="">个人主页</a>
			<a class="line" href="">编辑个人资料</a>
			<a class="line" href="">留言板</a>
        </div>
        <br/>
         <br/><br/><br/><br/><br/><br/><br/><br/>
       	<div class="left_inform">
        	<div class="head">
        	
        	<a class="line" href="zll.jsp">
        	<em class="speak1">查看</em><em class="speak2">制作者</em><em class="speak3">信息</em>
        	</a>
        	</div>
        </div>
    </div>
    <div class="body_right">
    
    	 <div class="right">
    		<div class="send_weibo">
        		<div class="w_tittle">
            		<div class="tittle">
                	<p class="txt">
                    <em class="speak1">有什么新</em>
                    <em class="speak2">鲜事</em>
                    <em class="speak3">想告诉大家</em>
                    <em class="speak4">?</em>
                    </p>
                	</div>
            	</div><br/>
            	<div class="input" node-type="textElDiv">
            		<textarea class="w_input" node-type="textEl" name="" title="微博输入框" range="0&0">
                	</textarea>
            	</div>
            	<div class="sub_area" node-type="wedget">
            		<div class="func">
                	<a class="submit" tittle="发布微博" href="">发布</a>
                	</div>
            	</div>
        	</div>
        </div>
                
	</div>
</div>
</body>
</html>
