<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<style>
.showanswerform{
    margin: 100px 0px 0px 450px;
    background-color: white;
    text-align: center;
    width: 500px;
    padding: 20px 20px 20px 20px;
    border-radius: 6px;
}
.achievement{

    display: flex;
    justify-content: space-between;
}

.cong{
    border-radius: 6px;
    margin: 20px 0px 20px 0px;
    padding: 50px 0px 50px 0px;
    background-color: antiquewhite;
}
.ansbtn{
    display: flex;
    justify-content: space-between;
    
}
.ansbtn form button{
    color:white;
    height:40px;
    width: 460px;
    border: none;
    background: #136a8a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #136a8a, #267871); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #136a8a, #267871); 
    border-radius: 6px;
    cursor: pointer;
}
</style>
<link rel="stylesheet" href="CSS/Home.css">
<body>
	
			<div class="header">
	<div class="okidoki">
	<h3>Quizi Choice</h3>
	<p class="sp">System</p>
	</div>
	
	
	

	</div>

  

    <div class="showanswerform">
        <div class="achievement">
        <p>${fullname}</p><p>Score : <span> ${score}</span>/ ${fullmark}</p>
    </div>
    <div class="cong">
        <span>Congragulation!</span>
    </div>
    <div class="ansbtn">
       
        <form action="Score"><button>View Score</button></form>
    </div>
    
    </div>





</body>
</html>