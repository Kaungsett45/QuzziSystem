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

import DBConnection.Method;
@WebServlet("/UserScore")
public class UserScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserScore() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
  
   



   
	protected void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Method method=new Method();
		List<Achievement>  js = method.getJavaScript();

		List<Achievement>  java = method.getJava();

		List<Achievement>  Cdouble = method.getCDouble();
		List<Achievement>  python = method.getPython();
		List<Achievement>  react = method.getReact();
		request.setAttribute("javascript", js);
		request.setAttribute("Cdouble",Cdouble);
		request.setAttribute("python",python);
		request.setAttribute("java",java);

		request.setAttribute("react",react);
		 RequestDispatcher rd=request.getRequestDispatcher("UserScore.jsp");
		 rd.forward(request,response);
		    
		}
		
	
	
}
