<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<link rel="stylesheet" href="CSS/Home.css">
<style>

.block1{
  position: absolute;
  top: 80px;
  left: 0px;
  clip-path: polygon(50% 0%, 0% 100%, 100% 100%);
  background-color:#a15ae8;
  height: 40px;
  width: 40px;
  transform: rotate(-32.245deg);
}
.block11{
  position: absolute;
  top: 180px;
  left: 650px;
  clip-path: polygon(50% 0%, 0% 100%, 100% 100%);
  background-color:#a15ae8;
  height: 20px;
  width: 20px;
  transform: rotate(-32.245deg);
}
.block2{
  position: absolute;
  top:450px;
  left:400px;
clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);  background-color:#5aafe8;
  height:20px;
  width:20px;
  flex-shrink: 0;
  transform: rotate(-32.245deg);
}
.block8{
  position: absolute;
  top:150px;
  right:400px;
clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);  background-color:#b716bd;
  height:20px;
  width:20px;
  flex-shrink: 0;
  transform: rotate(-32.245deg);
}

.block9{
  position: absolute;
  top:600px;
  right:100px;
clip-path: polygon(20% 0%, 0% 20%, 30% 50%, 0% 80%, 20% 100%, 50% 70%, 80% 100%, 100% 80%, 70% 50%, 100% 20%, 80% 0%, 50% 30%);  background-color:#77bd16;
  height:20px;
  width:20px;
  flex-shrink: 0;
  transform: rotate(-32.245deg);
}
.block3{
  position: absolute;
  top: 460px;
  left: 150px;
  width: 15px;
  height: 5px;
  transform: rotate(-32.245deg);
  flex-shrink: 0;  
  background: #E54040;
}

.block5{
  width: 50.758px;
  height: 30px;
  transform: rotate(-32.245deg);
  flex-shrink: 0;
  background: #C85F5F;
  position: absolute;
  top: 100px;
  right:150px;
}
.block6{
  position: absolute;
  top:522px;
  left:300px;
  clip-path: circle(40.1% at 58% 90%);
  background-color: #25a851;
  height: 100px;
  width:120px;
  flex-shrink: 0;
}



.clock{
  position: absolute;
  width: 260px;
 top:260px;
  right:50px;
  
  transform: rotate(-20deg);
}
.questionmark{
  width: 420px;
  position: absolute;
  top:120px;
  left:120px;
  -webkit-transform: scaleX(-1);
  transform: scaleX(-1);
}
.ques{
  width: 120px;
  position: absolute;
  transform: rotate(20deg);
  top:450px;
  left:0px;
}
.threeques{
  width: 120px;
  position: absolute;
  top:530px;
  left:840px;
}
.arbg2{
  width: 120px;
  position: absolute;
  top:200px;
  left:860px;
}
.arbg{
  width: 80px;
  position: absolute;
  
  transform: rotate(-80deg);
  top:220px;
  left:400px;
}
.t1{
  
  position: absolute;
  top: 80px;
  left: 400px;
  transform: rotate(-8deg);
}
.t2{
  
  position: absolute;
  top: 450px;
  right: 300px;
  transform: rotate(-13deg);
}
.t3{
  
  position: absolute;
}
.text{
    width: 400px;
    letter-spacing: 2px;
    text-align: center;
}
.navigation a::after ,button::after{
  content: '';
  position: absolute;
  bottom: 0;
  left: 0;
  width: 100%;
  height: 0.1em; 
   background: #2c3e50; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #2c3e50, #3498db); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #2c3e50, #3498db);
  opacity: 0;
  transition: opacity 300ms, transform 300ms;
  
}

/* Slide in */

.navigation li a ,button{
  overflow:hidden;
  color:black;
  font-weight:400;
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
      
        <li><a href="Home.jsp" class="home">Home</a></li>
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
    <!-- navigation -->

  <div class="bottom">
  <div class="left-text">
    <div class="text"> <div class="t1">Unlock Your <span>Knowledge</span>, </div> 
  <!--  <div class="t2">Embrace Your <span>Curiosity</span>.</div> --> 
    </div>
    <div class="left-Linked">
    <div class="layout1">
    <a href="Test.jsp">Take Your Test</a></div>
    </div>
    
  </div>
    <img src="image/exx.png" class="questionmark">
      <img src="image/clock.png" class="clock">
      <img src="image/sticker22.webp" class="ques">
      
      <img src="image/sticker.webp" class="threeques">
      <img src="image/arbg2.png" class="arbg">
      <img src="image/arbg2.png" class="arbg2">
  
  </div>
  
  
  
    <div class="block1"></div>
  <div class="block2"></div>
  <div class="block3"></div>
  <div class="block4"></div>
  <div class="block5"></div>
  <div class="block6"></div>
  
  <div class="block8"></div>
  
  <div class="block9"></div>
  
  <div class="block11"></div>
  
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