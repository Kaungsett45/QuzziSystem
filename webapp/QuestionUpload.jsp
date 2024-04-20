<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload</title>
</head>

<link rel="stylesheet" href="CSS/Home.css">
<link rel="stylesheet" href="CSS/questionupload.css">
<style>
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
  height:480px;
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
.navigation  a:after,
button:after
 {
  opacity: 0;
  transform: translate3d(0, 0, 0);
}

</style>
<body>
<div class="fixxi">
	<div class="header">
	
	
	<div class="okidoki">
	<h3>Quizi Choice</h3>
	<p class="sp">System</p>
	</div>
	<a href="QuestionUpload.jsp" class="logoutbtn2"><button class="Btnshowlist active">Question Upload</button></a>
	
	<a href="UserScore" class="logoutbtn2"><button class="Btnshowlist">User Score</button></a>
	<a href="UserList" class="logoutbtn2"><button class="Btnshowlist">User Lists</button></a>
	<form action="ShowQuestionList" method="post" class="logoutbtn2"><button class="Btnshowlist">QuestionList</button></form>
      
      <form action="ShowQuestionCodeList" method="post" class="logoutbtn2"><button class="Btnshowlist">QuestionCode List</button></form>
	
	<a href="index.jsp" class="logoutbtn2"><button class="Btnshowlist">Log out</button></a>
	</div>
	</div>
   <div class="wrapper">
         <div class="title-text">
            <div class="title login">
               Question Upload 
            </div>
            
            
            
         </div>
         <div class="form-container">
            
            <div class="form-inner">
            
            
            
            <!-- user form -->
               <form action="UploadQuestion" class="login" method="POST">
               
              	<input type = "hidden" name = "question_id" />
              	<input type = "hidden" name = "optionone_id"/>
              	<input type = "hidden" name = "optiontwo_id" />
              	<input type = "hidden" name = "optionthree_id" />
              	<input type = "hidden" name = "answeroption_id"/>
                  <div class="ques">
                  <div class="field">
                     <textarea placeholder="Question" name="description" rows="10" cols="60" required ></textarea>
                  </div>
                  <div class="radiobtn">
                     
                     
                     <input type="radio" name="subj" value="1" required>Java
                     <input type="radio" name="subj" value="2" required>Javascript
                     <input type="radio" name="subj" value="3" required>C++<br>
                      <input type="radio" name="subj" value="4" required>Python
                          <input type="radio" name="subj" value="5" required>React
                  </div>
                </div>
                <div class="option">
                
                <div class="checkquestion">
              	  <div class="field">
                     <input type="number" placeholder="Question Code"  name="questioncode" required>
                  </div>
                  <div class="field" id="okfiel">
                     <input type="text" placeholder="Score" class="ttfield" name="score" required>
                  </div>
                  </div>
                  
                  
                  <div class="field">
                     <input type="text" placeholder="Option 1"  name="option1" required>
                  </div>
                  
                  <div class="field">
                     <input type="text" placeholder="Option 2"  name="option2" required>
                  </div>
                  
                  <div class="field">
                     <input type="text" placeholder="Option 3"  name="option3" required>
                  </div>
                  
                  <div class="field">
                     <input type="text" placeholder="Answer"  name="answeroption" required>
                  </div>
                  
                  
                <p class="noti">${noti}</p>
                <div class="field btn" id="fieldbtn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Upload Question">
                  </div>
                  
                 </div>
                 
                
               </form>
              
              
              
          
               
            </div>
         </div>
      </div>
      
      
      
   
</body>
</html>