package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBMSConnection;
import Model.Users;

public class getusername {
    public static String getUserFullNameByEmailAndPassword(String email, String password) {
      
    	String fullName= null;
    	Users user = new Users();
        // Replace this with your actual database interaction code
        Connection connection = null;
        try {
            // Establish database connection
            connection = DBMSConnection.openConnection();
            
            // Prepare and execute SQL query
            String sql = "select fullname from users WHERE email = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                fullName = user.setFullname(resultSet.getString(1));
                System.out.println("print full name  "+ fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return fullName;
    }
}
