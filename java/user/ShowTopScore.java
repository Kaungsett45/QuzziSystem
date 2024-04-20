package user;



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
import javax.servlet.http.HttpSession;

import DBConnection.DBMSConnection;
import Model.Achievement;
import Model.Question;

/**
 * Servlet implementation class Registerdao
 */
@WebServlet("/ShowTopScore")
public class ShowTopScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTopScore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	 public List<Achievement> showache() {
	        List<Achievement> list = new ArrayList<>();
	        Achievement ques = null;

	        try {
	           
	            String sql="SELECT fullname, COUNT(*) AS subject_id, SUM(score) AS score FROM achievement  GROUP BY fullname order by  score desc";
	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Achievement();
	                ques.setSubject_id(resultSet.getInt("subject_id"));
	           
	                ques.setFullname(resultSet.getString("fullname"));
	                ques.setScore(resultSet.getString("score"));
	                list.add(ques);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		   List<Achievement> itemList =  showache();// Fetch the list of items from the database
			         HttpSession session = request.getSession();
			         request.setAttribute("Topshow", itemList);
			         
			         session.removeAttribute("subjid");
				     session.removeAttribute("score");

			         request.getRequestDispatcher("TopScore.jsp").forward(request, response);
	}

	}


