<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>

<link rel="stylesheet" href="CSS/questionupload.css">

<link rel="stylesheet" href="CSS/Home.css">
<style>
.option .checkquestion{
	display:flex;
	width:300px;
}

.option .checkquestion .field input[type="text"] {
	width:140px;
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
.wrapper{
	width:500px;
	height:300px;
	margin-top:100px;
	margin-left:140px;
}
.left-text{
	margin-left:40px;
}
.left-Linked{
	margin-top:-120px;
	margin-left:-36px;
}
</style>
<body>
	<div class="header">
	<div class="okidoki">
	<h3>Quizi Choice</h3>
	<p class="sp">System</p>
	</div>
	
	<a href="index.jsp" class="logoutbtn">Log out</a>
	</div>
   <div class="wrapper">
         <div class="title-text">
            <div class="title login">
               Question Upload Complete!
            </div>
            
            
            
         </div>
        
        
      
       
  <div class="left-text">
   
    <div class="left-Linked">
    <div class="layout1">
     <a href="QuestionUpload.jsp"> Upload Question Again</a></div>
    </div>
    
  </div></div>
      
      
      

</body>
</html>