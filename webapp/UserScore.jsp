<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="CSS/Home.css">
<link rel="stylesheet" href="CSS/questionupload.css">
</head>
<style>


	.subjectcontainer{
	overflow:hidden;
  display: flex;
  margin:20px 50px 20px 50px;
  box-shadow: 5px 5px 5px 0px rgba(0,0,0,0.3);
filter: drop-shadow(5px 5px 5px rgba(0,0,0,0.3));
  width:600px;
  background-color:#F5F5F5;
  height: 280px;
  padding: 10px 10px 10px 10px;
}
.subjectcontainer .subjname{
  background-color: white;
  text-align: center;
  width: 160px;
  height: 30px;
  padding: 4px 4px 4px 4px;
  border-radius: 4px;
}
.bblock{
  width: 160px;
}
.unamelist p{
	width:300px;
	padding:0px 8px 0px 8px; 

}
.unamelist{
  display: flex;
  width: 350px;
  height: 40px;
}
.userlist .unamelist p{
	text-align:left;
}
.flexccn{
  display: flex;
  justify-content:space-between;
}
.testimg{
  padding-top: 60px;
}
.testimg img{
  width: 100%;
  height: 100%;
}
.userlist{
  display: block;
   padding: 0px 20px 0px 20px;
  height: 270px;
  overflow-y: auto;
  overflow-x: hidden;
}
.option .checkquestion{
	display:flex;
	width:300px;
}

.option .checkquestion .field input[type="text"] {
	width:200px;
	padding: 0px 10px 0px 20px;
	
}
.option .checkquestion #okfiel .ttfield {
	width:130px;
	padding: 0px 10px 0px 20px;
	
}
.option .checkquestion .field {
		padding-right:30px;
		
	}
.option .checkquestion #okfiel{
	width:120px;
	padding: 0px 50px 0px 20px;
	
}
.noti{

	font-size:18px;
	margin-top:20px;
	color:green;
	letter-spacing:1px;
}

.Btnshowlist{
		text-decoration:none;
		
 		background-color:#ffffff00;
  		border-radius: 5px;
  		letter-spacing:1px;
  		border:none;
  		font-size:20px;
  		color:black;
  		cursor:pointer;
}
.active{
background: #136a8a; /* fallback for old browsers */
  		background: -webkit-linear-gradient(to right, #136a8a, #267871); /* Chrome 10-25, Safari 5.1-6 */
  		background: linear-gradient(to right, #136a8a, #267871); 
  		color:white;
  		padding:8px 8px 6px 8px;
}
.logoutbtn2{
text-decoration:none;
padding:4px 10px 0px 10px;
background-color:#ffffff00;
border-radius:5px;
color:white;
height:42px;
}
body{
	margin:20px 50px 20px 50px;
	position:relative;
	background-color:#F8FCFB;
	 
}


*{  font-family: 'Poppins', sans-serif;}
.wrapper{
  overflow: hidden;
  width:900px;
  height:450px;
  position:absolute;
  left:300px;
  background: #fff;
  padding: 30px;
  border-radius: 5px;
  box-shadow: 0px 15px 20px rgba(0,0,0,0.1);
 
}
.wrapper .title-text{
 margin-bottom:20px;
}
.wrapper .title-text{
  display: flex;
  width: 200%;
}
.wrapper .title{
  width: 50%;
  font-size: 30px;
  font-weight: 600;
  text-align: center;
  transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
}
.header{
	margin:0px;
	font-size:22px;
	display:flex;
	justify-content:space-between;
}
.header p{
	margin:0px;
}
.header h3{
	margin:0px;
}
.header .sp{
	font-size:16px;
}

.wrapper .form-container{
  width: 100%;
}
.form-container .form-inner{
  display: flex;
  width: 200%;
}
form{
	display:flex;
}
.form-container .form-inner form{
  width: 50%;
  transition: all 0.6s cubic-bezier(0.68,-0.55,0.265,1.55);
}
.form-inner form .field{
 height: 50px;
  width: 380px;
  margin-top: 20px;
}
.form-inner form .field input{
 	width:100%;
 	height:100%;
  outline: none;
  padding-left: 15px;
  border-radius: 5px;
  border: 1px solid lightgrey;
  border-bottom-width: 2px;
  font-size: 17px;
  transition: all 0.3s ease;
}


textarea{
 height: 200px;
  width: 320px;
  outline: none;
  padding-left: 15px;
  border-radius: 5px;
  border: 1px solid lightgrey;
  border-bottom-width: 2px;
  font-size: 17px;
  transition: all 0.3s ease;
}
.form-inner form .field input:focus,textarea:focus{
  border-color: #0B666A;
  /* box-shadow: inset 0 0 3px #fb6aae; */
}
.form-inner form .field input::placeholder ,textarea::placeholder{
  color: #999;
  transition: all 0.3s ease;
}
form .field input:focus::placeholder ,textarea:focus::placeholder{
  color: #b3b3b3;
}



form .btn{
  height: 50px;
  width: 100%;
  border-radius: 5px;
  position: relative;
  overflow: hidden;
}
form .btn .btn-layer{
  height: 100%;
  width: 300%;
  position: absolute;
  left: -100%;
 background: #136a8a; /* fallback for old browsers */
  background: -webkit-linear-gradient(to right, #136a8a, #267871); /* Chrome 10-25, Safari 5.1-6 */
  background: linear-gradient(to right, #136a8a, #267871); 
  border-radius: 5px;
  transition: all 0.4s ease;;
}
form .btn:hover .btn-layer{
  left: 0;
}
form .btn input[type="submit"]{
  height: 100%;
  width: 100%;
  z-index: 1;
  position: relative;
  background: none;
  border: none;
  color: #fff;
  padding-left: 0;
  border-radius: 5px;
  font-size: 20px;
  font-weight: 500;
  cursor: pointer;
}
.radiobtn{
	position:absolute;
	top:340px;
	font-size: 20px;
	font-weight: 500;
}
#fieldbtn{
	position:absolute;
	left:30px;
	top:380px;
	width:340px;
}
.radiobtn input[type="radio"]{
	margin-right:2px;
}

</style>
<body>
	<div class="header">
	<div class="okidoki">
	<h3>Quizi Choice</h3>
	<p class="sp">System</p>
	</div>
	<a href="QuestionUpload.jsp" class="logoutbtn2"><button class="Btnshowlist">Question Upload</button></a>
	
	<a href="UserScore" class="logoutbtn2"><button class="Btnshowlist active">User Score</button></a>
	<a href="UserList" class="logoutbtn2"><button class="Btnshowlist">User Lists</button></a>
	<form action="ShowQuestionList" method="post" class="logoutbtn2"><button class="Btnshowlist">QuestionList</button></form>
      
      <form action="ShowQuestionCodeList" method="post" class="logoutbtn2"><button class="Btnshowlist">QuestionCode List</button></form>
	
	<a href="index.jsp" class="logoutbtn2"><button class="Btnshowlist">Log out</button></a>
	</div>

<div class="flexccn">
    <div class="subjectcontainer">
         <div class="bblock">  
      <div class="subjname">JavaScript</div>
      <div class="testimg">
        <img src="image/javasc.png" alt="">
      </div>
    </div> 
    <div class="userlist">
      <div class="unamelist">
        <p>UserName</p>
        <p class="sc">Score</p>
        <p>date</p>
        
      </div>
      
       <c:forEach items="${javascript}" var="js" varStatus="status">
      <div class="unamelist">
        <p>${js.fullname}</p>
        <p class="sc">${js.score}</p>
                <p>${js.date}</p>
      </div>
      </c:forEach>
    </div>
    </div>

    <div class="subjectcontainer">
            
      <div class="bblock">  
        <div class="subjname">React</div>
        <div class="testimg">
          <img src="image/React.png" alt="">
        </div>
      </div> 
      
    <div class="userlist">
      <div class="unamelist">
        <p>UserName</p>
        <p class="sc">Score</p>
         <p>date</p>
      </div>
       <c:forEach items="${react}" var="js" varStatus="status">
      <div class="unamelist">
        <p>${js.fullname}</p>
        <p class="sc">${js.score}</p>
                <p>${js.date}</p>
      </div>
      </c:forEach>
    </div>
    </div>

  
  </div>

  
  
  
  
<div class="flexccn">
    <div class="subjectcontainer">
         <div class="bblock">  
      <div class="subjname">Java SE</div>
      <div class="testimg">
        <img src="image/java.png" alt="">
      </div>
    </div> 
    <div class="userlist">
      <div class="unamelist">
        <p>UserName</p>
        <p class="sc">Score</p>
         <p>date</p>
        
      </div>
      
       <c:forEach items="${java}" var="js" varStatus="status">
      <div class="unamelist">
        <p>${js.fullname}</p>
         <p class="sc">${js.score}</p>
        <p>${js.date}</p>
       
      </div>
      </c:forEach>
    </div>
    </div>

    <div class="subjectcontainer">
            
      <div class="bblock">  
        <div class="subjname">Python</div>
        <div class="testimg">
          <img src="image/python.png" alt="">
        </div>
      </div> 
      
    <div class="userlist">
      <div class="unamelist">
        <p>UserName</p>
         <p class="sc">Score</p>
         <p>date</p>
      </div>
       <c:forEach items="${python}" var="js" varStatus="status">
      <div class="unamelist">
        <p>${js.fullname}</p>
        <p class="sc">${js.score}</p>
        <p>${js.date}</p>
      </div>
      </c:forEach>
    </div>
    </div>

  
  </div>

  
  
  
<div class="flexccn">
    <div class="subjectcontainer">
         <div class="bblock">  
      <div class="subjname">C++</div>
      <div class="testimg">
        <img src="image/Cc.png" alt="">
      </div>
    </div> 
    <div class="userlist">
      <div class="unamelist">
        <p>UserName</p>
         <p class="sc">Score</p>
         <p>date</p>
      </div>
      
       <c:forEach items="${Cdouble}" var="js" varStatus="status">
      <div class="unamelist">
          <p>${js.fullname}</p>
        <p class="sc">${js.score}</p>
        <p>${js.date}</p>
      </div>
      </c:forEach>
    </div>
    </div>

    <div class="subjectcontainer">
            
      <div class="bblock">  
        <div class="subjname">Java J2EE</div>
        <div class="testimg">
          <img src="image/React.png" alt="">
        </div>
      </div> 
      
    <div class="userlist">
      <div class="unamelist">
        <p>UserName</p>
        <p class="sc">Score</p>
        <p>date</p>
      </div>
       <c:forEach items="" var="js" varStatus="status">
      <div class="unamelist">
          <p>${js.fullname}</p>
        <p class="sc">${js.score}</p>
        <p>${js.date}</p>
      </div>
      </c:forEach>
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