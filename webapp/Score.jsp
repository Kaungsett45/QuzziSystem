<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/Home.css">
<title>Insert title here</title>
</head>
<style>
	.opacityen{
  margin:10px 30px 10px 30px;
  display: flex;
  justify-content: space-between;
  background-color: white;
  padding: 10px 10px;
  color:rgb(0, 0, 0);
  font-size: 20px;
  border-radius: 6px;
}

.topscored{
  margin:10px 30px 10px 30px;
  display: flex;
  justify-content: space-between;
  background-color: #118A8A;
  padding: 10px 10px;
  color:white;
  font-size: 20px;
  border-radius: 6px;
}
.topscored p ,.opacityen p{
  width: 200px;
  text-align: center;
}
.contop{
   margin-top: 50px;
}
.topscored .uname ,.opacityen .uname{
  text-align: left;
  padding-left:60px;
}
	
	.cehcki{
		text-align:center;
		color:red;
		margin-top:200px;
		font-size:20px;
	}
	
.navigation .home:after,
button:after
 {
  opacity: 1;
  transform: translate3d(0, 0, 0);
}
	
</style>
<body>

 <div class="header">
    <div class="okidoki">
    <h3>Quizi Choice</h3>
    <p class="sp">System</p>
    </div>
    
    
    <nav>
    <div class="navigation" id="">
      <ul>
      
        <li><a href="Home.jsp">Home</a></li>
        <li><a href="Score" class="home">Score</a></li>
        <li><a href="ShowTopScore">Top Scorers</a></li>
        <li><a href="Aboutus.jsp">About us</a></li>
        <li><a href="#" onclick="logout()">Log out</a></li>
      </ul>
      
      <form id="logoutForm" action="Logout"  method="POST" style="display: none;"><button></button></form>
    <!-- You can include additional form fields if needed -->

    
    </div>
  </nav>
    </div>
  	<%	


Object check=request.getAttribute("python");
  	String oki = check.toString();
  	String cc = "[]";
  	System.out.println("Check value: " + oki);
	if(oki.equals(cc) || oki== null){
		
	
%>
	<h4 class="cehcki">Today passed without any tests being taken.</h4>


<%}else{ %>
	<div class="contop">
    <div class="topscored">
       
       <p class="uname">User Name</p>
       <p>Subject</p>
       <p>Time</p>
       <p>Score</p>
    </div>

   
	 <c:forEach var="item" items="${python}">
                <div class="opacityen">
      
      <p class="uname">${item.fullname}</p>
      <p>${item.subject}</p>
      <p>${item.time}</p>
      <p>${item.score}</p>
   </div>
            </c:forEach>

  </div>
  <%} %>
  
    <script>
  document.getElementById("clear").addEventListener("click", function() {
    sessionclear();
  });
    
  function logout() {
      document.getElementById("logoutForm").submit();
  }
  
  </script>
</body>
</html>