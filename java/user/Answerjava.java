package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBMSConnection;
import Model.Question;

import DBConnection.Method;
@WebServlet("/Answerjava")
public class Answerjava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answerjava() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Users user = new Users();
		Method method = new Method();
	String subject=request.getParameter("subject_id");
		String check=request.getParameter("question");
		
		
		 if (method.questionExists(check)) {
		    // Question exists, redirect to question page
		    response.sendRedirect("AnswerTest.jsp");
		} else {
		    // Question doesn't exist, show error
		    request.setAttribute("errors","This questioncode doesn't exit");
			 RequestDispatcher rd=request.getRequestDispatcher("Questioncode.jsp");
			 rd.include(request,response);
		    
		}
		
	}
	

	public void sessionclear(HttpSession session) {
		
	        session.removeAttribute("fullname");
			System.out.println("clear session");
			
	}
	
}
