package admin;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.JdbcConnection;

import DBConnection.DBMSConnection;
import Model.Question;
import Model.Subjects;
import DBConnection.Method;

@WebServlet("/ShowQuestionCodeList")
public class ShowQuestionCodeList extends HttpServlet {
		
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestionCodeList() {
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
	
	
	///insert subject
	
	
	
	   
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//doGet(request, response);
		Method method = new Method();
		PrintWriter out=response.getWriter();
		  Connection con = DBMSConnection.openConnection();
		Question ques = new Question();
         
        
		
		 List<Question> quelist = method.QuesCodeget();
			request.setAttribute("questionlist", quelist);
        
		
		RequestDispatcher rd = request.getRequestDispatcher("QuestionCodeList.jsp");
		rd.forward(request, response);
	    
	}
}
		
		


