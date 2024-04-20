package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBMSConnection;
import Model.Users;

@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Users user = new Users();
		PrintWriter out =response.getWriter();
		try {
			
			Connection con=DBMSConnection.openConnection();
			String email=request.getParameter("email");
			String password=request.getParameter("password");
		
			PreparedStatement ps =con.prepareStatement("select * from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs =ps.executeQuery();
			String fullName = getusername.getUserFullNameByEmailAndPassword(email, password);
			
			
			if(rs.next()) {
				
					 HttpSession session = request.getSession();
			         session.setAttribute("fullname", fullName);
			         System.out.println("Registeruser name please got" + fullName);
				request.getRequestDispatcher("Home.jsp").include(request, response);  
				}else {
					request.setAttribute("usererror","Username or password is wrong");
					 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
					 rd.include(request,response);
					// String error=request.getParameter("error");
					 
				
				}
		} catch ( SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void sessionclear(HttpSession session) {
		
	        session.removeAttribute("fullname");
			System.out.println("clear session");
			
	}
	
}
