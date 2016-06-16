package ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Article;

public class addArticle extends HttpServlet {


	public addArticle() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
			System.out.println("********addarticle*******");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("******addArticle*****");
			String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
			String today=format.format(new Date());
			try {
				
				Connection con=null;
				Statement pre=null;
				ResultSet rs=null;
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=gbk";
				con=DriverManager.getConnection(url,"root","200769033zll");
				pre=con.createStatement();
				String sql1="select * from article";
				rs=pre.executeQuery(sql1);
				int k=0;
				while(rs.next()){
					k++;
				}
				int id=k;
				System.out.println("aaaaaaaaaaaaaaaa");
				String sql2="insert into article "+" (id,content,name,jointime) "+" values ("+"'"+id+"'"+","+"'"+content+"'"+","+"'"+name+"'"+","+"'"+today+"'"+")";
				pre.executeUpdate(sql2);
				
				String sql3="select * from article";
				rs=pre.executeQuery(sql3);
				
				ArrayList articleList=new ArrayList();
				HttpSession session=request.getSession();	
				while(rs.next()){	
					Article article=new Article();
					article.setName(rs.getString("name"));
					article.setContent(rs.getString("content"));
					article.setJointime(rs.getString("jointime"));
					articleList.add(article);
					session.setAttribute("articleList", articleList);
				}
				request.getSession().setAttribute("name", name);

				response.sendRedirect("http://localhost:8080/Myblock/index_login.jsp");
				rs.close();
				pre.close();
				con.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
