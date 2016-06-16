package ser;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import pojo.User;

public class RegisterSer extends HttpServlet {

	public RegisterSer() {
		super();
	}

	
	public void destroy() {
		super.destroy(); 
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			System.out.println("--------register-----------");
			String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String password1=new String(request.getParameter("password1").getBytes("ISO-8859-1"),"UTF-8");
			String password2=new String(request.getParameter("password2").getBytes("ISO-8859-1"),"UTF-8");
			String age=new String(request.getParameter("age").getBytes("ISO-8859-1"),"UTF-8");
			String birth=new String(request.getParameter("birth").getBytes("ISO-8859-1"),"UTF-8");
			String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
			String lan=new String(request.getParameter("lan").getBytes("ISO-8859-1"),"UTF-8");
			String zodiac=new String(request.getParameter("zodiac").getBytes("ISO-8859-1"),"UTF-8");
			String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String email=new String(request.getParameter("email").getBytes("ISO-8859-1"),"UTF-8");
			String note=new String(request.getParameter("note").getBytes("ISO-8859-1"),"UTF-8");
			if(name.equals("")||age.equals("")||birth.equals("")||sex.equals("")||lan.equals("")||zodiac.equals("")||address.equals("")||email.equals("")||email.equals("")||note.equals("")){
				System.out.println("-------MessageNull-----");				
				request.getSession().setAttribute("Info", "信息不能为空");
				response.sendRedirect("http://localhost:8080/Myblock/register_fail.jsp");
			}else if(password1.equals("")||password2.equals("")){
				request.getSession().setAttribute("Info", "密码不能为空");
				response.sendRedirect("http://localhost:8080/Myblock/register_fail.jsp");
			}else if(!password1.endsWith(password2)){
				request.getSession().setAttribute("Info", "两次密码不相同");
				response.sendRedirect("http://localhost:8080/Myblock/register_fail.jsp");
			}else if(age.equals("")||birth.equals("")||sex.equals("")||lan.equals("")||zodiac.equals("")||address.equals("")||email.equals("")||email.equals("")||note.equals("")){
				request.getSession().setAttribute("Info", "不能有空");
				response.sendRedirect("http://localhost:8080/Myblock/register_fail.jsp");
			}else{
				
				try {
					Connection con=null;
					Statement pre=null;
					ResultSet rs=null;
					Class.forName("com.mysql.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/myblog?useUnicode=true&characterEncoding=gbk";
					con=DriverManager.getConnection(url, "root", "200769033zll");
					pre=con.createStatement();
					String sql1="select * from users where name='"+name+"'";
					rs=pre.executeQuery(sql1);
					rs.last();
					int k;
					k=rs.getRow();
					if(k>0){
						request.getSession().setAttribute("Info", "用户名已存在，注册失败");
						response.sendRedirect("http://localhost:8080/Myblock/register_fail.jsp");
					}else{
						
						
						System.out.println("----------insert------------");
						String sql2="insert into users "+" (name,password,age,birth,sex,lan,zodiac,address,email,note)"+" values ("+"'"+name+"'"+","+"'"+password1+"'"+","+"'"+age+"'"+","+"'"+birth+"'"+","+"'"+sex+"'"+","+"'"+lan+"'"+","+"'"+zodiac+"'"+","+"'"+address+"'"+","+"'"+email+"'"+","+"'"+note+"'"+")";
						pre.executeUpdate(sql2);
						response.sendRedirect("http://localhost:8080/Myblock/login.jsp");
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
