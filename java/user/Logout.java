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

import Model.Users;


@WebServlet(value = "/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
        HttpSession session = request.getSession();
        session.removeAttribute("fullname"); // Clear the session attribute
        session.invalidate(); // Invalidate the session
        System.out.println("session clear");
        // Redirect to the login page
        response.sendRedirect(request.getContextPath() + "/index.jsp");

	}
	
	
}
	
