package ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.User;

public class ShowInfoSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowInfoSer() {
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
			System.out.println("-----------------");
			try {
				System.out.println("------Post----");
				//String name=request.getParameter("name");
				String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
				System.out.println(name);
				Connection con=null;
				Statement pre=null;
				ResultSet rs=null;
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=gbk";
				con=DriverManager.getConnection(url,"root","200769033zll");
				pre=con.createStatement();
				String sql="select * from users where name='"+name+"'";
				rs=pre.executeQuery(sql);
				User user=new User();
				while(rs.next()){
					
					user.setAge(rs.getString("age"));
					user.setBirth(rs.getString("birth"));
					user.setSex(rs.getString("sex"));
					user.setLan(rs.getString("lan"));
					user.setZodiac(rs.getString("zodiac"));
					user.setAddress(rs.getString("address"));
					user.setEmail(rs.getString("email"));
					user.setNote(rs.getString("note"));
				}
				HttpSession session=request.getSession();
				ArrayList wordlist=new ArrayList();
				wordlist.add(user);
				session.setAttribute("wordlist", wordlist);
				
				response.sendRedirect("http://localhost:8080/Myblock/info.jsp");
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
