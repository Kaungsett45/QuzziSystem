<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="CSS/index.css">

</head>

<body>
		<div class="header">
	<div class="okidoki">
	<h3>Quizi Choice</h3>
	<p class="sp">System</p>
	</div>
	
	</div>
		
	<div class="containingform">
		   <div class="wrapper">
         <div class="title-text">
            <div class="title login">
               Registeration
            </div>
            <div class="title signup">
               LogIn
            </div>
         </div>
         <div class="form-container">
           
            <div class="form-inner">
            
            
            
            <!-- user form -->
               <form action="Register" method="Post" class="login">
               <div class="field">
                     <input type="text" name="fullname" placeholder="Username" required>
                  </div>
                  <div class="field">
                     <input type="email" name="email" placeholder="Email Address" required>
                  </div>
                  <div class="field">
                     <input type="password" name="password" placeholder="Password" required>
                  </div>
                 
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Register">
                  </div>
               
               
                <div class="field btn">
                     <p style="color:red;">${errors}</p>
                     
                  </div>
               </form>
              
              
              
              <!-- admin form -->
               <form action="Login" method="POST" class="signup">
                  <div class="field">
                     <input type="email" placeholder="Email Address"  name="email" required>
                  </div>
                  <div class="field">
                     <input type="password" placeholder="Password" name="password" required>
                  </div>
                  
                  <div class="field btn">
                     <div class="btn-layer"></div>
                     <input type="submit" value="Login">
                  </div>
                  
                   <div class="field btn">
                     <p style="color:red;">${error}</p>
                     
                  </div>
               </form>
               
               
               
               
            </div>
         </div>
      </div>
      
      </div>
      
      
      <script>
         const loginText = document.querySelector(".title-text .login");
         const loginForm = document.querySelector("form.login");
         const loginBtn = document.querySelector("label.login");
         const signupBtn = document.querySelector("label.signup");
         signupBtn.onclick = (()=>{
           loginForm.style.marginLeft = "-50%";
           loginText.style.marginLeft = "-50%";
         });
         loginBtn.onclick = (()=>{
           loginForm.style.marginLeft = "0%";
           loginText.style.marginLeft = "0%";
         });
         signupLink.onclick = (()=>{
           signupBtn.click();
           return false;
         });
      </script>
</body>
</html>

   
 