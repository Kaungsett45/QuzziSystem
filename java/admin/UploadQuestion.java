package admin;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.mysql.cj.jdbc.JdbcConnection;

import DBConnection.DBMSConnection;
import Model.Question;
import Model.Subjects;

;
@WebServlet("/UploadQuestion")
public class UploadQuestion extends HttpServlet {
		
	Connection connection = null;
	ResultSet resultSet = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadQuestion() {
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
	public int insertoptionone(Question q) {
	    int generatedId = 1; // Initialize with a default value

	    String sql = "insert into optionone (description, subject_id) values (?, ?)";

	    try (Connection connection = DBMSConnection.openConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        preparedStatement.setString(1, q.getDescription());
	        preparedStatement.setInt(2, q.getSubject_id());

	        int rowInserted = preparedStatement.executeUpdate();
	        if (rowInserted > 0) {
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    generatedId = generatedKeys.getInt(1); // Get the generated ID
	                    System.out.println("Option one is inserted with ID: " + generatedId);
	                }
	            }
	        }

	    } catch (SQLException ex) {
	        // Log the error using a proper logging framework
	        ex.printStackTrace();
	    }

	    return generatedId;
	}
	
	public int insertoptiontwo(Question q) {
	    int generatedId = 1; // Initialize with a default value

	    String sql = "insert into optiontwo (description, subject_id) values (?, ?)";

	    try (Connection connection = DBMSConnection.openConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        preparedStatement.setString(1, q.getDescriptiontwo());
	        preparedStatement.setInt(2, q.getSubject_id());

	        int rowInserted = preparedStatement.executeUpdate();
	        if (rowInserted > 0) {
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    generatedId = generatedKeys.getInt(1); // Get the generated ID
	                    System.out.println("Option two is inserted with ID: " + generatedId);
	                }
	            }
	        }

	    } catch (SQLException ex) {
	        // Log the error using a proper logging framework
	        ex.printStackTrace();
	    }

	    return generatedId;
	}

	public int insertoptionthree(Question q) {
	    int generatedId = 1; // Initialize with a default value

	    String sql = "insert into optionthree (description, subject_id) values (?, ?)";

	    try (Connection connection = DBMSConnection.openConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        preparedStatement.setString(1, q.getDescriptionthree());
	        preparedStatement.setInt(2, q.getSubject_id());

	        int rowInserted = preparedStatement.executeUpdate();
	        if (rowInserted > 0) {
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    generatedId = generatedKeys.getInt(1); // Get the generated ID
	                    System.out.println("Option three is inserted with ID: " + generatedId);
	                }
	            }
	        }

	    } catch (SQLException ex) {
	        // Log the error using a proper logging framework
	        ex.printStackTrace();
	    }

	    return generatedId;
	}

	
	public int insertanswer(Question q) {
	    int generatedId = 1; // Initialize with a default value

	    String sql ="insert into answeroption (description,subject_id,score) values(?,?,?)";

	    try (Connection connection = DBMSConnection.openConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        preparedStatement.setString(1, q.getAnswerdescription());
	        preparedStatement.setInt(2, q.getSubject_id());
	        preparedStatement.setString(3, q.getScore());
	        int rowInserted = preparedStatement.executeUpdate();
	        if (rowInserted > 0) {
	            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    generatedId = generatedKeys.getInt(1); // Get the generated ID
	                    System.out.println("Option one is inserted with ID: " + generatedId);
	                }
	            }
	        }

	    } catch (SQLException ex) {
	        // Log the error using a proper logging framework
	        ex.printStackTrace();
	    }

	    return generatedId;
	}


	
	
	public boolean Questioninsert(Question q) throws SQLException {
		boolean flag=false;
		try {
		String sql ="insert into question(question_title,subject_id,optionone_id,optiontwo_id,optionthree_id,answeroption_id,questioncode)values(?,?,?,?,?,?,?)";
		connection  = DBMSConnection.openConnection();
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,q.getQuestion_title());
		preparedStatement.setInt(2,q.getSubject_id());
		preparedStatement.setInt(3,q.getOptionone_id());
		preparedStatement.setInt(4,q.getOptiontwo_id());
		preparedStatement.setInt(5,q.getOptionthree_id());
		preparedStatement.setInt(6,q.getAnsweroption_id());
		preparedStatement.setString(7,q.getQuestioncode());
		int rowInserted = preparedStatement.executeUpdate();
		if (rowInserted > 0) flag = true;
		}catch(SQLException ex) {
		ex.printStackTrace();

		}
		System.out.println("answeroption is inserted");
		return flag;
	}
	//insert optionone

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//doGet(request, response);
		PrintWriter out=response.getWriter();
		  try {
	            Connection con = DBMSConnection.openConnection();
	            Question ques = new Question();
	            String subjid=request.getParameter("subj");
	            ques.setSubject_id(Integer.parseInt(subjid));
	            ques.setDescription(request.getParameter("option1"));
	            
	            
	            ques.setDescriptiontwo(request.getParameter("option2"));
	            
	            
	            ques.setDescriptionthree(request.getParameter("option3"));
	            
	            ques.setAnswerdescription(request.getParameter("answeroption"));
	            ques.setScore(request.getParameter("score"));
	            
	            
	            ques.setQuestion_title(request.getParameter("description"));
	            ques.setQuestioncode(request.getParameter("questioncode"));
	          
	            
	          
	            int optionOneId = insertoptionone(ques);
	            int optiontwoId = insertoptiontwo(ques);
	            int optionthreeId = insertoptionthree(ques);
	            int optionansId = insertanswer(ques);

	            ques.setOptionone_id(optionOneId);
	            ques.setOptiontwo_id(optiontwoId);
	            ques.setOptionthree_id(optionthreeId);
	            ques.setAnsweroption_id(optionansId);
	            Questioninsert(ques);
	          
	            
	            RequestDispatcher rd = request.getRequestDispatcher("QuestionUploadComplete.jsp");
	            rd.forward(request, response);
	            
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
	}
}
		
		


