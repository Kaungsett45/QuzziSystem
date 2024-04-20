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

@WebServlet("/QuestionEdit")
public class QuestionEdit extends HttpServlet {
		
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionEdit() {
        super();
        // TODO Auto-generated constructor stub
    }
	

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
	    // Assuming you've obtained the necessary input values
	    int questionId = Integer.parseInt(request.getParameter("question_id"));
	    String newQuestionTitle = request.getParameter("description");
	    int newSubjectId = Integer.parseInt(request.getParameter("subj"));
	    String newQuestionCode = request.getParameter("questioncode");
	    String newOptionOneDescription = request.getParameter("option1");
	    String newOptionTwoDescription = request.getParameter("option2");
	    String newOptionThreeDescription = request.getParameter("option3");
	    String newAnswerOptionDescription = request.getParameter("answeroption");
	    String newAnswerOptionScore = request.getParameter("score");
	    
	    Connection connection = DBMSConnection.openConnection();
	   
	    
	    PreparedStatement updateOptionOne = connection.prepareStatement("UPDATE optionone SET description=? WHERE optionone_id=?");
	    updateOptionOne.setString(1, newOptionOneDescription);
	    updateOptionOne.setInt(2, questionId);
	    updateOptionOne.executeUpdate();
	    
	    PreparedStatement updateOptionTwo = connection.prepareStatement("UPDATE optiontwo SET description=? WHERE optiontwo_id=?");
	    updateOptionTwo.setString(1, newOptionTwoDescription);
	    updateOptionTwo.setInt(2, questionId);
	    updateOptionTwo.executeUpdate();
	    
	    PreparedStatement updateOptionThree = connection.prepareStatement("UPDATE optionthree SET description=? WHERE optionthree_id=?");
	    updateOptionThree.setString(1, newOptionThreeDescription);
	    updateOptionThree.setInt(2, questionId);
	    updateOptionThree.executeUpdate();
	    
	    PreparedStatement updateAnswerOption = connection.prepareStatement("UPDATE answeroption SET description=?, score=? WHERE answeroption_id=?");
	    updateAnswerOption.setString(1, newAnswerOptionDescription);
	    updateAnswerOption.setString(2, newAnswerOptionScore);
	    updateAnswerOption.setInt(3, questionId);
	    updateAnswerOption.executeUpdate();
	    
	    
	    PreparedStatement updateQuestion = connection.prepareStatement("UPDATE question SET question_title=?, subject_id=?, questioncode=? WHERE question_id=?");
	    updateQuestion.setString(1, newQuestionTitle);
	    updateQuestion.setInt(2, newSubjectId);
	    updateQuestion.setString(3, newQuestionCode);
	    updateQuestion.setInt(4, questionId);
	    updateQuestion.executeUpdate();
	    // Close the resources
	    connection.close();
	    
	    // Redirect to a success page or back to the question list
	    request.setAttribute("noti", "Question edit complete");
		RequestDispatcher rd = request.getRequestDispatcher("QuestionUpload.jsp");
		rd.forward(request, response);
	} catch (SQLException | NumberFormatException e) {
	    e.printStackTrace();
	    // Handle the exception (e.g., show an error message)
	    response.sendRedirect("error_page.jsp");
	}
}
}
