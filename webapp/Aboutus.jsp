<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<link rel="stylesheet" href="CSS/Home.css">

<link rel="stylesheet" href="CSS/About.css">
<style>

.box h3{
padding:0px;
margin-top:40px;
font-size:22px;
width:300px;

}
.team{
	margin-top:40px;
	padding:0px;

}
.ddteam{
	margin-top:-40px;
	padding:0px;
	margin-left:120px;
}

.center h1{
	color:black;
}
	.box img{
	height:100%;
	width:100%;
	}
	
	.box {
	margin-top:-200px;
	display:block;
	height:400px;
	
	}
	.tetimg{
		width:280px;
		height:250px;
	}
	
	.ddteam .tetimg{
		
	width:260px;
		height:300px;
	}
	
	.tetimg img{
		width:100%;
		height:100%;
	}
	.ddteam  .box{
		width:290px;
		
	}
	.ddteam  .box h3,.ddteam  .box h5{
		margin-top:0px;
	}
	.navigation .home:after,
button:after
 {
  opacity: 1;
  transform: translate3d(0, 0, 0);
}
	
	.team .team-content .box .tetimg img{
		width:270px;
		margin-left:-20px;
	}
	.team .team-content .box h3{
		margin-left:-20px;
	}
	.ddteam .team-content .box h3{
		margin-top:10px;
		margin-left:-20px;
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
        <li><a href="Aboutus.jsp" class="home">About us</a></li>
        <li><a href="#" onclick="logout()">Log out</a></li>
      </ul>
      
      <form id="logoutForm" action="Logout"  method="POST" style="display: none;"><button></button></form>
    <!-- You can include additional form fields if needed -->

    
    </div>
  </nav>
  
  </div>
	
	
		<section class="team">
		

		<div class="team-content">
			<div class="box">
				<div class="tetimg">
				<img src="image/Akd.jpg"></div>
				<h3>Aung Kaung Sett</h3>
				<h5>Project Manager</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>

			<div class="box">
			
				<div class="tetimg">
				<img src="image/Minthway.jpg">
				</div>
				<h3>Min Thway Khant</h3>
				<h5>Back-End Developer</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>

			<div class="box">
			
				<div class="tetimg">
				<img src="image/Minthet.jpg">
				</div>
				<h3>Min Thet Lwin</h3>
				<h5>Back-End Developer</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>

			<div class="box">
			
				<div class="tetimg">
				<img src="image/Katone.jpg">
				</div>
				<h3>Swan Pyae Aung</h3>
				<h5>Database Designer</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>
			
		
		
			</div>
			
		
	</section>
		<section class="ddteam">
		
			
			<div class="team-content">
			<div class="box">
				<div class="tetimg">
				<img src="image/EC.jpg"></div>
				<h3>Khin Hnin Htet</h3>
				<h5>UI/UX Designer</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>

			<div class="box">
			
				<div class="tetimg">
				<img src="image/MoeMoe.jpg">
				</div>
				<h3>Moe Thiri Khin</h3>
				<h5>Front-End Developer</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>

			<div class="box">
			
				<div class="tetimg">
				<img src="image/Khinchan.jpg">
				</div>
				<h3>Khin Chan Thar</h3>
				<h5>Front-End Developer</h5>
				<div class="icons">
					<a href="#"><i class="ri-twitter-fill"></i></a>
					<a href="#"><i class="ri-facebook-box-fill"></i></a>
					<a href="#"><i class="ri-instagram-fill"></i></a>
				</div>
			</div>

	
		
			</div>
			</section>
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