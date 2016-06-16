package ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Article;

public class ShowBlogSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowBlogSer() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		try {
			Connection con=null;
			Statement pre=null;
			ResultSet rs=null;
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=gbk";
			con=DriverManager.getConnection(url,"root","200769033zll");
			pre=con.createStatement();
			String sql="select * from article where name='"+name+"'";
			rs=pre.executeQuery(sql);
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
					
			System.out.println("----post6----");
			
			response.sendRedirect("http://localhost:8080/Myblock/myblog.jsp");
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
