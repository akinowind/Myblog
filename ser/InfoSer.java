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

import pojo.User;

public class InfoSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InfoSer() {
		super();
	}

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
			System.out.println("--------register-----------");
			
			System.out.println("-----password-----");
			String age=new String(request.getParameter("age").getBytes("ISO-8859-1"),"UTF-8");
			String birth=new String(request.getParameter("birth").getBytes("ISO-8859-1"),"UTF-8");
			String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
			String lan=new String(request.getParameter("lan").getBytes("ISO-8859-1"),"UTF-8");
			String zodiac=new String(request.getParameter("zodiac").getBytes("ISO-8859-1"),"UTF-8");
			String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String email=new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
			String note=new String(request.getParameter("note").getBytes("ISO-8859-1"),"UTF-8");
			if(age.length()==0||birth.length()==0||sex.length()==0||lan.length()==0||zodiac.length()==0||address.length()==0||email.length()==0||note.length()==0){
				request.getSession().setAttribute("Info", "信息不能为空");
				response.sendRedirect("http://localhost:8080/Myblock/info_fail.jsp");
			}else{
				try {
					Connection con=null;
					Statement pre=null;
					ResultSet rs=null;
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=gbk";
					con=DriverManager.getConnection(url, "root", "200769033zll");
					pre=con.createStatement();
					String userName="";
					HttpSession session=request.getSession();
					ArrayList login=(ArrayList)session.getAttribute("login");
					if(login==null||login.size()==0){
						
						response.sendRedirect("http://localhost:8080/Myblock/index_login.jsp");
					}else{
						for(int i=login.size()-1;i>=0;i--){
							User user=(User)login.get(i);
							userName=user.getName();
						}
					}
					String sql="update users set age='"+age+"',birth='"+birth+"',sex='"+sex+"',lan='"+lan+"',zodiac='"+zodiac+"',address='"+address+"',email='"+email+"',note='"+note+"' where name='"+userName+"'";
					pre.executeUpdate(sql);
					String sql2="select * from users where name='"+userName+"'";
					rs=pre.executeQuery(sql2);
					User user=new User();
					while(rs.next()){
						user.setName(rs.getString("name"));
						user.setPassword(rs.getString("password"));
						user.setAge(rs.getString("age"));
						user.setBirth(rs.getString("birth"));
						user.setSex(rs.getString("sex"));
						user.setLan(rs.getString("lan"));
						user.setZodiac(rs.getString("zodiac"));
						user.setAddress(rs.getString("address"));
						user.setEmail(rs.getString("email"));
						user.setNote(rs.getString("note"));
					}
					ArrayList wordlist=null;
					wordlist=new ArrayList();
					wordlist.add(user);
					request.getSession().setAttribute("name", userName);
					session.setAttribute("wordlist", wordlist);
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
			
	}

		public void init() throws ServletException {
		// Put your code here
	}

}
