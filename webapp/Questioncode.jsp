<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>

<link rel="stylesheet" href="CSS/Home.css">

<link rel="stylesheet" href="CSS/index.css">
<style>

.quescode{

	display:flex;
	justify-content:center;
	

}
.code{
	width:400px;
	height:200px;
}
.con23{
	font-size:22px;
	font-weight:bold;
	
}
.code input[type="text"]{
	
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
        <li><a href="Score">Score</a></li>
        <li><a href="ShowTopScore">Top Scorers</a></li>
        <li><a href="Aboutus.jsp">About us</a></li>
        <li><a href="#" onclick="logout()">Log out</a></li>
      </ul>
      
      <form id="logoutForm" action="Logout"  method="POST" style="display: none;"><button></button></form>
    <!-- You can include additional form fields if needed -->

    
    </div>
  </nav>
	</div>

    <p class="poet"> <span>Ch</span>oose  from <span>Three Inspiring Subjects</span> and <span>Unleash Your Full Potential</span> Today!</p>
	
	
       <div class="containingform">
		   <div class="wrapper">
        <div class="title-text">
            <div class="title login">
               Add Question Code
            </div>
            </div>
         <div class="form-container">
           
            <div class="form-inner">
            
            <!-- user form -->
               <form action="CheckQuestion" method="Post" class="login">
               <input type = "hidden" name ="subject" value="1" />
               <div class="field">
                     <input type="number" name="question" placeholder="Question Code Here.." required>
                  </div>
              	<span>${errors}</span>
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Add">
                  </div>
               
               
              
               </form>
               
            </div>
         </div>
      </div>
      
      </div>
	
	




 
    
    
    
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