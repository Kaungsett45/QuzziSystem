package admin;

import java.io.IOException;
import java.sql.Connection;
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

import DBConnection.DBMSConnection;
import Model.Question;
import DBConnection.Method;
@WebServlet("/EditDelete")
public class EditDelete extends HttpServlet {
	
	
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Method method = new Method();
    	String action = request.getParameter("action");
    	
    	if (action != null) {
    	    if (action.equals("Edit")) {
    	        // Handle edit action
    	        // Retrieve the question ID from the request parameter
    	        String idStr = request.getParameter("id");
    	        int questionId = Integer.parseInt(idStr);
    	        
    	        // Retrieve the question with the specified ID and populate the edit form
    	        request.setAttribute("ques", method.getQuestionById(questionId));	
    	        request.getRequestDispatcher("QuestionUploadEdit.jsp").forward(request, response);
    	    } else if (action.equals("Delete")) {
    	        // Handle delete action
    	        // Delete the question with the specified ID
    	        // Redirect to the question list page or wherever you want
    	    	String idStr = request.getParameter("code");
    	    	String subid = request.getParameter("id");
    	    	int consubid =Integer.parseInt(subid);
    	      
    	    		method.Deletequestioncode(idStr,consubid);
    	    	 List<Question> quelist = method.QuesCodeget();
    				request.setAttribute("questionlist", quelist);
    				request.setAttribute("noti", "Delete completetd!");
    	        	
    	        request.getRequestDispatcher("QuestionCodeList.jsp").forward(request, response);
    	    }
    	}

    }


}
