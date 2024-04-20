package admin;


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
import Model.Users;

import DBConnection.Method;
@WebServlet("/UserList")
public class UserList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserList() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
  
   



    
   
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Method method = new Method();
		List<Users>  js = method.getUser();
		request.setAttribute("ucount", method.usercount());
		request.setAttribute("userlist", js);
		 RequestDispatcher rd=request.getRequestDispatcher("UserList.jsp");
		 rd.forward(request,response);
		    
		}
		
	
	
}
