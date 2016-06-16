<%@page import="java.util.*" %>
<%@page import="pojo.User" %>
<%@page import="pojo.Article" %>
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
<%
	String userName=null;
	ArrayList login=(ArrayList)session.getAttribute("login");
	for(int i=login.size()-1;i>=0;i--){
		User user=(User)login.get(i);
		userName=user.getName();
	}
	System.out.println("---------"+userName);
 %>
<body>
<a class="href" href="index.jsp">退出登录</a>
<span style="padding-left:60px; color:red;">
<a class="href">
        <% 
        String name=request.getParameter("name");
        if(request.getSession().getAttribute("name")!=null){
        	out.print(request.getSession().getAttribute("name"));
        }
      
        %>
</a>
</span>
<br/>
<div class="top">
	<div class="ph_photo" node-type="photo">
    	<p class="photo_wrap">
    	<a href="">
       <br/> <img class="image" src="img/20130310195946_Ccnma.thumb.600_0.jpeg">
        </a>
        </p>
    </div>
    <br/>
	<div class="ph_username">
    <span class="username">
            <% if(request.getSession().getAttribute("name")!=null){
        	out.print(request.getSession().getAttribute("name"));
        }
      
        %>
    </span>
    
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
            <a class="line" href="http://localhost:8080/Myblock/ShowBlogSer?name=<%=userName %>">个人主页</a>
            <a class="line" href="http://localhost:8080/Myblock/ShowInfoSer?name=<%=userName %>">编辑个人资料</a>
            <a class="line" href="http://localhost:8080/Myblock/ShowMessageSer?name=<%=userName %>">留言板</a>
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/>
       	<div class="left_inform">
        	<div class="head">
        	<a class="line" href="zll.jsp">
        	<em class="speak1">查看</em><em class="speak2">制作者</em><em class="speak3">信息</em>
        	</a>
        	</div>
        	<div >
        	
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
            	<form action="/Myblock/addArticle?name=<%=userName %>" method="post">
            	<div class="input" node-type="textElDiv">
            		<textarea class="w_input" node-type="textEl" name="content" title="微博输入框" range="0&0">
                	</textarea>
            	</div>
            	<div class="sub_area" node-type="wedget">
            		<div class="func">
            		<button class="submit"  tabindex="5px" data-img="确认中" type="submit">发布</button>
                	</div>
            	</div>
            	</form>
        	</div>
        </div>
    	
    	<%
    		ArrayList articleList=(ArrayList)session.getAttribute("articleList");
    		//System.out.println(articleList.size());
    		if(articleList ==null)
    			out.print("没有博文");
    		else {
    			for(int i=articleList.size()-1;i>=0;i--){
    				System.out.println(i);
    				Article article=(Article)articleList.get(i);
    	 %>
    	 <div class="right">
        	<div class="padding">
        		<div class="wb_face">
        		<a title="" href="">
        		<img class="wb_face_dadius" src="img/20130310195946_Ccnma.thumb.600_0.jpeg"/>
        		</a>
        		</div>
        		<div class="wb_detail">
        			<div class="wb_head">
        			<a class="wb_href" href=""><%=article.getName() %></a>
        			</div>
        			<div class="wb_body">
        			<%=article.getContent() %>
        			</div> 
        			<div class="wb_time">
        			<a href=""><%=article.getJointime() %></a>
        			</div> 		
        		</div>
        		<div class="wb_font">
        			<ul class="wb_row">
    				<li><a class="wb_txt1" href="">评论</a></li>
    				<li><a class="wb_txt1" href="">浏览</a></li>
        			</ul>
        		</div>
        		<br/>
        		<div class="wb_comment">
        		<br/>
        			<div class="wb_cbox">
        				<div class="wb_cface">
        				<img src="img/20130310195946_Ccnma.thumb.600_0.jpeg">
        				</div>
        				<div class="wb_cinput">
        					<textarea class="wb_textinput">
        					</textarea>
        					<div class="wb_publish">
        					<button class="wb_submit"  tabindex="5px" data-img="确认中" type="submit">评论</button>
        					</div>
        				</div>
        			</div>
        			<br/>
        			<div class="wb_repeatlist">
        				<div class="list_box">
        					<div class="list_ul">
        					
        					
        						<div class="list_li">
        							<div class="ul_face">
        							<img src="img/20130310195946_Ccnma.thumb.600_0.jpeg">
        							</div>
        							<div class="ul_con">
        								<div class="wb_head">
        								<a class="wb_href" href=""><%=article.getName() %></a>
        								</div>
        								<div class="wb_body">
        								<%=article.getContent() %>
        								</div> 
        								<div class="wb_time">
        								<a href=""><%=article.getJointime() %></a>
        								</div> 		        							
        							</div>
        						</div>
        						
        						<div class="list_li">
        							<div class="ul_face">
        							<img src="img/20130310195946_Ccnma.thumb.600_0.jpeg">
        							</div>
        							<div class="ul_con">
        								<div class="wb_head">
        								<a class="wb_href" href=""><%=article.getName() %></a>
        								</div>
        								<div class="wb_body">
        								<%=article.getContent() %>
        								</div> 
        								<div class="wb_time">
        								<a href=""><%=article.getJointime() %></a>
        								</div> 		        							
        							</div>
        						</div>
        						
        						
        						
        					</div>
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
         <%
         	}
         }
          %>      
        
    </div>
</div>
</body>
</html>
