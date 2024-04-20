package user;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import DBConnection.DBMSConnection;
import Model.Question;


@WebServlet("/CheckQuestion")
public class CheckQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Question get(int id) {
    	Question q = null;
    	try {

    	q = new Question();
    //	String sql = " select * from question,optionone,optiontwo,optionthree,answeroption where questioncode=" +id+" and question_id=optionone.optionone_id and question_id=optiontwo.optiontwo_id and question_id=optionthree.optionthree_id and question_id=answeroption.answeroption_id";
    	String sql=" select question_title,optionone.description,optiontwo.description,optionthree.description,answeroption.description,answeroption.score from question,optionone,optiontwo,optionthree,answeroption where questioncode="+id+" and question_id=optionone.optionone_id and question_id=optiontwo.optiontwo_id and question_id=optionthree.optionthree_id and question_id=answeroption.answeroption_id";
    	Connection connection = DBMSConnection.openConnection();
    	Statement statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	if(resultSet.next()) {

    	q.setQuestion_title(resultSet.getString("question_title"));
    	q.setSubject_id(resultSet.getInt("subject_id"));
    	q.setOptionone_id(resultSet.getInt("optionone_id"));
    	q.setOptiontwo_id(resultSet.getInt("optiontwo_id"));
    	q.setOptionthree_id(resultSet.getInt("optionthree_id"));
    	q.setAnsweroption_id(resultSet.getInt("answeroption_id"));
    	q.setDescription(resultSet.getString("description"));
    	q.setDescriptiontwo(resultSet.getString("description"));
    	q.setDescriptionthree(resultSet.getString("description"));
    	q.setAnswerdescription(resultSet.getString("description"));
    	q.setScore(resultSet.getString("score"));
    	}

    	}catch(SQLException e) {
    	e.printStackTrace();

    	}
    	return q;
    	}
	
    
    public boolean questionExists( String question) {
        boolean exists = false;

        try {
            String sql = "SELECT * FROM question WHERE questioncode=?";
            Connection connection = DBMSConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, question);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }
   
    public int getSubjid(String questionCode, int subjectId) {
        int resultSubjectId = 0; // Default value indicating no subject found

        try {
            String sql = "SELECT subject_id FROM question WHERE questioncode = ? AND subject_id = ?";
            Connection connection = DBMSConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, questionCode);
            preparedStatement.setInt(2, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resultSubjectId = resultSet.getInt("subject_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSubjectId;
    }



    
    public int questioncount(String question) {
        int count = 0; // Initialize count to 0

        try {
            String sql = "SELECT COUNT(*) FROM question WHERE questioncode=?";
            Connection connection = DBMSConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, question);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1); // Get the count value from the result set
            }

            // Close the resources (connection, statement, result set)
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count; // Return the count value
    }

    
    public List<Question> qget(String questioncode, int subjectId) {
        List<Question> list = new ArrayList<>();
        Question ques = null;

        try {
            String sql = "SELECT question.*, " +
                         "optionone.description AS optionone_desc, " +
                         "optiontwo.description AS optiontwo_desc, " +
                         "optionthree.description AS optionthree_desc, " +
                         "answeroption.description AS answeroption_desc, " +
                         "answeroption.score AS answeroption_score " +
                         "FROM question " +
                         "INNER JOIN optionone ON question.optionone_id = optionone.optionone_id " +
                         "INNER JOIN optiontwo ON question.optiontwo_id = optiontwo.optiontwo_id " +
                         "INNER JOIN optionthree ON question.optionthree_id = optionthree.optionthree_id " +
                         "INNER JOIN answeroption ON question.answeroption_id = answeroption.answeroption_id " +
                         "WHERE question.questioncode = ? AND question.subject_id = ?"; 

            Connection connection = DBMSConnection.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, questioncode);
            preparedStatement.setInt(2, subjectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ques = new Question();
                ques.setQuestion_id(resultSet.getInt("question_id"));
                ques.setQuestion_title(resultSet.getString("question_title"));
                ques.setSubject_id(resultSet.getInt("subject_id"));
                ques.setOptionone_id(resultSet.getInt("optionone_id"));
                ques.setDescription(resultSet.getString("optionone_desc"));
                ques.setOptiontwo_id(resultSet.getInt("optiontwo_id"));
                ques.setDescriptiontwo(resultSet.getString("optiontwo_desc"));
                ques.setOptionthree_id(resultSet.getInt("optionthree_id"));
                ques.setDescriptionthree(resultSet.getString("optionthree_desc"));
                ques.setAnsweroption_id(resultSet.getInt("answeroption_id"));
                ques.setAnswerdescription(resultSet.getString("answeroption_desc"));
                ques.setScore(resultSet.getString("answeroption_score"));
                ques.setQuestioncode(resultSet.getString("questioncode"));
                list.add(ques);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//Users user = new Users();
		String subject = request.getParameter("subject");
		int subjcetint = Integer.parseInt(subject);
		System.out.println("Convert to int " + subjcetint);
	String check= request.getParameter("question");
	System.out.println("questioncode check" + check);
		Question q = new Question();
			
		 List<Question> quelist = qget(check,subjcetint);
		 int count =questioncount(check);
		
	
		 // Change variable name to subjidget
		 System.out.println("subject_id checking with integer " + subject);
		 System.out.println("subject _id from dbms check" + getSubjid(check,subjcetint));
		 int  checkres = getSubjid(check,subjcetint);
		// resultSet.getString("subject_id")
		 if (questionExists(check) && subjcetint == checkres){
		    // Question exists, redirect to question page
		
			System.out.println("list check" + quelist);
			System.out.println("Count" +questioncount(check));
			request.setAttribute("count", questioncount(check));
			request.setAttribute("quelist", quelist);
			HttpSession session=request.getSession();
			session.setAttribute("subjid", subject);
		    request.getRequestDispatcher("TakeTest.jsp").forward(request, response);
			 
		} else {
		    // Question doesn't exist, show error
			if(subjcetint == 3) {
		    request.setAttribute("errors","This questioncode doesn't exit");
			 RequestDispatcher rd=request.getRequestDispatcher("CCode.jsp");
			 rd.include(request,response);
			}
			
			if(subjcetint == 2) {
			    request.setAttribute("errors","This questioncode doesn't exit");
				 RequestDispatcher rd=request.getRequestDispatcher("javascriptcode.jsp");
				 rd.include(request,response);
				}
			
			if(subjcetint == 1) {
			    request.setAttribute("errors","This questioncode doesn't exit");
				 RequestDispatcher rd=request.getRequestDispatcher("Questioncode.jsp");
				 rd.include(request,response);
				}
			
			if(subjcetint == 4) {
			    request.setAttribute("errors","This questioncode doesn't exit");
				 RequestDispatcher rd=request.getRequestDispatcher("Pythoncode.jsp");
				 rd.include(request,response);
				}
			
			if(subjcetint == 5) {
			    request.setAttribute("errors","This questioncode doesn't exit");
				 RequestDispatcher rd=request.getRequestDispatcher("Reactcode.jsp");
				 rd.include(request,response);
				}
		    
		    
		}
		
	}
	

	public void sessionclear(HttpSession session) {
		
	        session.removeAttribute("fullname");
			System.out.println("clear session");
			
	}
	
}
