package ser;

import java.io.IOException;
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
import pojo.User;

public class LoginSer extends HttpServlet {

	

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		 
		
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		if(name.equals("")){
			System.out.println("-------MessageNull-----");
			
			request.getSession().setAttribute("Info", "用户名不能为空");
			response.sendRedirect("http://localhost:8080/Myblock/login_fail.jsp");
		}else if(password.equals("")){
			request.getSession().setAttribute("Info", "密码不能为空");
			response.sendRedirect("http://localhost:8080/Myblock/login_fail.jsp");
		}else{			
			try {
				
				Connection con=null;
				Statement pre=null;
				ResultSet rs=null;
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=gbk";
				con=DriverManager.getConnection(url,"root","200769033zll");
				pre=con.createStatement();
				String sql="select * from users";
				rs=pre.executeQuery(sql);
				System.out.println("-------sqlQuery------");
				int flag=0;
				User user=new User();
				while(rs.next()){
					System.out.println(rs.getString("name"));
					String userName = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
					String userPassword =new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
					
					if(userName.equals(name)){
						System.out.println("-----用户名匹配----");
						if(userPassword.equals(password)){
							flag=1;
							user.setName(userName);
							System.out.println("----flag=1----");
							user.setPassword(userPassword);
							/*request.getSession().setAttribute("name", name);
							response.sendRedirect("http://localhost:8080/Myblock/index_login.jsp");*/
						}
						/*else{
							request.getSession().setAttribute("Info", "用户名或密码不正确");
							response.sendRedirect("http://localhost:8080/Myblock/login_fail.jsp");
							}*/
					}/*else if(!userName.equals(request.getParameter("name"))){
						request.getSession().setAttribute("Info", "用户名或密码不正确");
						response.sendRedirect("http://localhost:8080/Myblock/login_fail.jsp");
					}*/
				}
				if(flag==1){
					request.getSession().setAttribute("name", name);
					HttpSession session=request.getSession();
					ArrayList login=new ArrayList();
					login.add(user);
					session.setAttribute("login", login);//(前面的login是字符串名字，后面的是值
					
					String sql3="select * from article";
					rs=pre.executeQuery(sql3);
					
					ArrayList articleList=new ArrayList();
					HttpSession session1=request.getSession();
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
				}
				if(flag==0){
					request.getSession().setAttribute("Info", "用户名或密码不正确");
					response.sendRedirect("http://localhost:8080/Myblock/login_fail.jsp");
				}
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
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
