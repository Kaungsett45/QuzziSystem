package user;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.DBMSConnection;

/**
 * Servlet implementation class Registerdao
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
PrintWriter out=response.getWriter();
		
		try {
			
			Connection con=DBMSConnection.openConnection();
			
			String name=request.getParameter("fullname");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			PreparedStatement st =con.prepareStatement("insert into users(email,password,fullname) values(?,?,?)");
			
			st.setString(1, email);
			st.setString(2,password);
			st.setString(3, name);
			st.executeUpdate();
			
			if(name != null &&  email !=null && password != null) {
				 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				 rd.forward(request,response);
			}else {
				 out.println("Registeration failed");
				 out.println("Register.jsp");
			}
		}catch( SQLException e){
			e.printStackTrace();
		}
	}

	}


