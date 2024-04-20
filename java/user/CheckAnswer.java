package user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.DBMSConnection;
import Model.Achievement;
import Model.Question;
import DBConnection.Method;

@WebServlet("/CheckAnswer")
public class CheckAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Users user = new Users();
		Method method = new Method();
		 HttpSession session = request.getSession();
	        String subjectIdStr = (String) session.getAttribute("subjid");
	        int subjectId = Integer.parseInt(subjectIdStr);
	        String questioncode = request.getParameter("questioncode");
	        List<Question> quelist = method.qget(questioncode,subjectId); 
	        System.out.println("quesiton size check " +quelist.size());
	        System.out.println("Engllisht question" + method.qget(questioncode,subjectId));// Replace with your database query method
	        int finalcheck = 0;

	        for (int i = 0; i < quelist.size(); i++) {
	            String questionName = "answeroption-" + i + "-" + quelist.get(i).getQuestion_id();
	            String selectedOption = request.getParameter(questionName);
	            System.out.println("selectOptionid check" + selectedOption);
	            int correctOptionId = quelist.get(i).getAnsweroption_id();
	            	System.out.println("result calculate" +correctOptionId);
	            if (selectedOption != null && selectedOption.equals(String.valueOf(correctOptionId))) {
	            	int score = method.getScoreForAnswerOption(correctOptionId);
	            	finalcheck += score;
	                System.out.println("count result "+finalcheck);
	            }
	        }

	        int finalScore = finalcheck;
	    
	        request.setAttribute("score", finalScore);
	        request.setAttribute("subject", subjectId);
	        String fullname = (String) session.getAttribute("fullname");
	        request.setAttribute("fullname",fullname);
	        LocalDateTime oki =LocalDateTime.now();
	    	DateTimeFormatter DateFormat =  DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    	DateTimeFormatter DateFormat2 =  DateTimeFormatter.ofPattern("HH:mm");
	    	String date =oki.format(DateFormat);
	    	String time =oki.format(DateFormat2);
	        method.insertUserScore(subjectId,finalScore,fullname,date,time);
	        
	        request.setAttribute("fullmark",method.getallcount(questioncode,subjectId));
		     System.out.println("fullmark  check" +method.getallcount(questioncode,subjectId));
	       
	        request.getRequestDispatcher("Showanswerform.jsp").forward(request, response);
	    }

	public void sessionclear(HttpSession session) {
		
	        session.removeAttribute("fullname");
			System.out.println("clear session");
			
	}
	
}
