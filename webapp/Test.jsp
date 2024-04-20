<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<style>
	.opacityen{
  margin:10px 30px 10px 30px;
  display: flex;
  justify-content: space-between;
  background-color: #adeaea;
  padding: 5px 5px;
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
}
.quescode .code{
width:280px;
}
</style>
<link rel="stylesheet" href="CSS/Home.css">
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
	
	
       
	
	<div class="examcontainer">


        <div class="picstart">

            <img src="image/javasc.png" alt="">
            
               <a href="javascriptcode.jsp"><button>START</button></a>
            
            
        </div>
         <div class="picstart">

            <img src="image/Cc.png" alt="">
            
           <input type = "hidden" name = "subj_id"  value="3"/>
               <a href="CCode.jsp"><button>START</button></a>
            
            
        </div>
        
           <div class="picstart">

            <img src="image/React.png" alt="">
            
               <a href="Reactcode.jsp"><button>START</button></a>
            
            
        </div>

        <div class="picstart">

            <img src="image/java4.png" alt="">
            
                <a href="Questioncode.jsp"><button>START</button></a>
            
        </div>


		  <div class="picstart">

            <img src="image/python.png" alt="">
            
                <a href="Pythoncode.jsp"><button>START</button></a>
            
        </div>
    </div>




    <div class="quescode">

        <div class="code">
            <div class="con23"><p>Question code</p>
                <span>  JavaScript</span></div>
            <div class="con1234"><p>232323</p></div>
            
        </div>

        <div class="code">
            <div class="con23"><p>Question code</p>
                <span>  C++</span></div>
            <div class="con1234"><p>234154</p></div>
            
        </div>
        
           <div class="code">
            <div class="con23"><p>Question code</p>
                <span>  React</span></div>
            <div class="con1234"><p>864324</p></div>
            
        </div>

        <div class="code">
            <div class="con23"><p>Question code</p>
                <span>  Java</span></div>
            <div class="con1234"><p>867352</p></div>
            
        </div>
         <div class="code">
            <div class="con23"><p>Question code</p>
                <span>  Python</span></div>
            <div class="con1234"><p>675143</p></div>
            
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