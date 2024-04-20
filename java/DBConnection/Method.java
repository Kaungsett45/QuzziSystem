package DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Achievement;
import Model.Question;
import Model.Users;

public class Method {
	
	
	public Question getQuestionById(int questionId) {
	    Question ques = null;

	    try {
	        String sql = "SELECT question.question_id, question_title, " +
	                     "optionone.description AS optionone_desc, " +
	                     "optiontwo.description AS optiontwo_desc, " +
	                     "optionthree.description AS optionthree_desc, " +
	                     "answeroption.description AS answeroption_desc, " +
	                     "answeroption.score AS answeroption_score, " +
	                     "question.questioncode, question.subject_id " +
	                     "FROM question " +
	                     "INNER JOIN optionone ON question.question_id = optionone.optionone_id " +
	                     "INNER JOIN optiontwo ON question.question_id = optiontwo.optiontwo_id " +
	                     "INNER JOIN optionthree ON question.question_id = optionthree.optionthree_id " +
	                     "INNER JOIN answeroption ON question.question_id = answeroption.answeroption_id " +
	                     "WHERE question.question_id = ? " +
	                     "GROUP BY question.question_id";

	        Connection connection = DBMSConnection.openConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setInt(1, questionId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) {
	            ques = new Question();
	            ques.setQuestion_id(resultSet.getInt("question_id"));
	            ques.setQuestion_title(resultSet.getString("question_title"));
	            
	            ques.setDescription(resultSet.getString("optionone_desc"));
	            ques.setDescriptiontwo(resultSet.getString("optiontwo_desc"));
	            ques.setDescriptionthree(resultSet.getString("optionthree_desc"));
	            ques.setAnswerdescription(resultSet.getString("answeroption_desc"));
	            ques.setScore(resultSet.getString("answeroption_score"));
	            ques.setQuestioncode(resultSet.getString("questioncode"));
	            ques.setSubject_id(resultSet.getInt("subject_id"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ques;
	}
	
	
	public Question Deletequestioncode(String questioncode,int subject_id) {
	    Question ques = null;

	    try {
	    	 String deleteQuery = "DELETE question, optionone, optiontwo, optionthree " +
                     "FROM question " +
                     "LEFT JOIN optionone ON question.optionone_id = optionone.optionone_id " +
                     "LEFT JOIN optiontwo ON question.optiontwo_id = optiontwo.optiontwo_id " +
                     "LEFT JOIN optionthree ON question.optionthree_id = optionthree.optionthree_id " +
                     "WHERE question.questioncode = ? and question.subject_id = ? ";

	        Connection connection = DBMSConnection.openConnection();
	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setString(1, questioncode);
	        preparedStatement.setInt(2, subject_id);
	        int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " rows deleted.");

            // Close the resources
            preparedStatement.close();
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return ques;
	}

	 public List<Question> QuesCodeget() {
	        List<Question> list = new ArrayList<>();
	        Question ques = null;

	        try {
	            String sql="select count(questioncode)as question_id,subject,question.subject_id,questioncode from question,subjects where question.subject_id=subjects.subject_id group by questioncode,question.subject_id";
	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Question();
	                ques.setQuestion_id(resultSet.getInt("question_id"));
	                ques.setSubject(resultSet.getString("subject"));
	                ques.setSubject_id(resultSet.getInt("subject_id"));
	                ques.setQuestioncode(resultSet.getString("questioncode"));
	               
	                list.add(ques);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	 

	 public List<Question> qget() {
	        List<Question> list = new ArrayList<>();
	        Question ques = null;

	        try {
	            String sql = "select question.question_id,subjects.subject,question_title,optionone.optionone_id,optiontwo.optiontwo_id,optionthree.optionthree_id,answeroption.answeroption_id,answeroption.score,question.questioncode from question,subjects,optionone,optiontwo,optionthree,answeroption where question.question_id=optionone.optionone_id and question.question_id=optiontwo.optiontwo_id and question.question_id=optionthree.optionthree_id and answeroption.answeroption_id=question.question_id and question.subject_id=subjects.subject_id";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Question();
	                ques.setQuestion_id(resultSet.getInt("question_id"));
	                ques.setSubject(resultSet.getString("subject"));
	                ques.setQuestion_title(resultSet.getString("question_title"));
	                ques.setOptionone_id(resultSet.getInt("optionone_id"));
	                ques.setOptiontwo_id(resultSet.getInt("optiontwo_id"));
	                ques.setOptionthree_id(resultSet.getInt("optionthree_id"));
	                ques.setAnsweroption_id(resultSet.getInt("answeroption_id"));
	                ques.setQuestioncode(resultSet.getString("questioncode"));
	                ques.setScore(resultSet.getString("score"));
	                list.add(ques);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	 
	 public int questionCount() {
		    int count = 0; // Initialize count to 0

		    try {
		        String sql = "SELECT COUNT(*) FROM question";
		        Connection connection = DBMSConnection.openConnection();
		        PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
	 
	 
	 public List<Users> getUser() {
	        List<Users> list = new ArrayList<>();
	        Users ques = null;

	        try {
	            String sql = "select id,fullname,email from users";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Users();

	                ques.setId(resultSet.getInt("id"));
	                ques.setFullname(resultSet.getString("fullname"));
	                ques.setEmail(resultSet.getString("email"));
	               
	                list.add(ques);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	    
	    
	    public int usercount() {
	        int count = 0; // Initialize count to 0

	        try {
	            String sql = "SELECT COUNT(*) FROM users";
	            Connection connection = DBMSConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
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

	    
	    
	    
	    
	    public List<Achievement> getReact() {
	        List<Achievement> list = new ArrayList<>();
	        Achievement ques = null;

	        try {
	            String sql = "select fullname,score,date,time from achievement where subject_id=5";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Achievement();
	                ques.setScore(resultSet.getString("score"));
	                ques.setFullname(resultSet.getString("fullname"));

	                ques.setDate(resultSet.getString("date"));

	                ques.setTime(resultSet.getString("time"));
	               
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
	            String sql = "select fullname,score,date,time from achievement where subject_id=2";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Achievement();
	                ques.setScore(resultSet.getString("score"));
	                ques.setFullname(resultSet.getString("fullname"));
	                ques.setDate(resultSet.getString("date"));
	                ques.setTime(resultSet.getString("time"));
	               
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
	            String sql = "select fullname,score,date,time from achievement where subject_id=1";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Achievement();
	                ques.setScore(resultSet.getString("score"));
	                ques.setFullname(resultSet.getString("fullname"));
	                ques.setDate(resultSet.getString("date"));
	                ques.setTime(resultSet.getString("time"));
	               
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
	            String sql = "select fullname,score,date,time from achievement where subject_id=3";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Achievement();
	                ques.setScore(resultSet.getString("score"));
	                ques.setFullname(resultSet.getString("fullname"));
	                ques.setDate(resultSet.getString("date"));
	                ques.setTime(resultSet.getString("time"));
	               
	                list.add(ques);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
	    public List<Achievement> getPython() {
	        List<Achievement> list = new ArrayList<>();
	        Achievement ques = null;

	        try {
	            String sql = "select fullname,score,date,time from achievement where subject_id=4";

	            Connection connection = DBMSConnection.openConnection();
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            while (resultSet.next()) {
	                ques = new Achievement();
	                ques.setScore(resultSet.getString("score"));
	                ques.setFullname(resultSet.getString("fullname"));
	                ques.setDate(resultSet.getString("date"));
	                ques.setTime(resultSet.getString("time"));
	               
	                list.add(ques);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
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


	    //user score
	    public void insertUserScore( int subjectId, int finalScore,String fullname,String date, String time) {
	        try {
	        	
	           

	            String sql = "INSERT INTO achievement (subject_id,score,fullname,date,time) VALUES (?, ?, ?, ?, ?)";
	            Connection connection = DBMSConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, subjectId);
	            preparedStatement.setInt(2, finalScore);
	            preparedStatement.setString(3,fullname);
	            preparedStatement.setString(4,date);
	            preparedStatement.setString(5,time);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
		
	    public int getallcount(String questionCode,int subjectid) {
	        int subjectId = 0; // Default value indicating no subject found

	        try {
	            String sql = " select  sum(score) as score from question,answeroption where answeroption.answeroption_id=question.answeroption_id and questioncode=? and question.subject_id= ?";
	            Connection connection = DBMSConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, questionCode);
	            preparedStatement.setInt(2, subjectid);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                subjectId = resultSet.getInt("score");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return subjectId;
	    }
	    
	    public int getScoreForAnswerOption(int answerOptionId) {
	        int score = 0;

	        try {
	            String sql = "SELECT score FROM answeroption WHERE answeroption_id = ?";
	            Connection connection = DBMSConnection.openConnection();
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, answerOptionId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	                score = resultSet.getInt("score");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return score;
	    }

	  
	 
}
