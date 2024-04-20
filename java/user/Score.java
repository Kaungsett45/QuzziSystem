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
import Model.Achievement;
import Model.Question;


@WebServlet("/Score")
public class Score extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
  
   



    
    public List<Achievement> getReact() {
        List<Achievement> list = new ArrayList<>();
        Achievement ques = null;

        try {
            String sql = "select fullname,score from achievement where subject_id=5";

            Connection connection = DBMSConnection.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ques = new Achievement();
                ques.setScore(resultSet.getString("score"));
                ques.setFullname(resultSet.getString("fullname"));
               
                list.add(ques);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Achievement> getJavaScript() {
        List<Achievement> list = new ArrayList<>();
        Achievement ques = null;

        try {
            String sql = "select fullname,score from achievement where subject_id=2";

            Connection connection = DBMSConnection.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ques = new Achievement();
                ques.setScore(resultSet.getString("score"));
                ques.setFullname(resultSet.getString("fullname"));
               
                list.add(ques);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public List<Achievement> getJava() {
        List<Achievement> list = new ArrayList<>();
        Achievement ques = null;

        try {
            String sql = "select fullname,score from achievement where subject_id=1";

            Connection connection = DBMSConnection.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ques = new Achievement();
                ques.setScore(resultSet.getString("score"));
                ques.setFullname(resultSet.getString("fullname"));
               
                list.add(ques);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Achievement> getCDouble() {
        List<Achievement> list = new ArrayList<>();
        Achievement ques = null;

        try {
            String sql = "select fullname,score from achievement where subject_id=3";

            Connection connection = DBMSConnection.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                ques = new Achievement();
                ques.setScore(resultSet.getString("score"));
                ques.setFullname(resultSet.getString("fullname"));
               
                list.add(ques);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<Achievement> getSubjectResultsWithinOneDay() {
        List<Achievement> list = new ArrayList<>();
        Achievement achievement = null;

        try {
            String sql = "SELECT a.fullname, a.time, a.score, s.subject " +
                         "FROM achievement a " +
                         "JOIN subjects s ON a.subject_id = s.subject_id " +
                         "WHERE a.answerdate >= DATE_SUB(NOW(), INTERVAL 45 Minute) " +
                         "ORDER BY a.score DESC";

            Connection connection = DBMSConnection.openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                achievement = new Achievement();
                achievement.setFullname(resultSet.getString("fullname"));
                achievement.setTime(resultSet.getString("time"));
                achievement.setScore(resultSet.getString("score"));
                achievement.setSubject(resultSet.getString("subject"));
                list.add(achievement);
            }
            
            // Close the resources (connection, statement, result set)
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		List<Achievement>  js = getJavaScript();

		List<Achievement>  python = getSubjectResultsWithinOneDay();
	
		request.setAttribute("python",python);
	
		 RequestDispatcher rd=request.getRequestDispatcher("Score.jsp");
		 rd.forward(request,response);
		    
		}
		
	
	
}
