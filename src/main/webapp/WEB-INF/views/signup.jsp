<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" >

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" ></script>
 -->


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   
   
<script src="./resources/js/jquery.validate.js"></script>


<script type="text/javascript">

$().ready(function() {
 
$("#signupForm").validate({
	rules: {  
		firstName: {
			required: true,
			minlength: 2
		},
		lastName: {
			required: true,
			minlength: 2
		},
		password: {
			required: true,
			minlength: 5
		},
		confirm_password: {
			required: true,
			minlength: 5,
			equalTo: "#password"
		},
		email: {
			required: true,
			email: true
		} 
	},
	messages: { 
		firstName: {
			required: "Please enter your First Name",
			minlength: "Your First Name must consist of at least 2 characters"
		},
		lastName: {
			required: "Please enter your Last Name",
			minlength: "Your Last Name must consist of at least 2 characters"
		},
		password: {
			required: "Please provide a password",
			minlength: "Your password must be at least 5 characters long"
		},
		confirm_password: {
			required: "Please provide a password confirmation",
			minlength: "Your password must be at least 5 characters long",
			equalTo: "Please enter the same password as above"
		},
		email: "Please enter a valid email address" 
	}
});
});
</script> 
 
 
 <style>
 .signup-btn {
  background: #79bc64;
  background-image: -webkit-linear-gradient(top, #79bc64, #578843);
  background-image: -moz-linear-gradient(top, #79bc64, #578843);
  background-image: -ms-linear-gradient(top, #79bc64, #578843);
  background-image: -o-linear-gradient(top, #79bc64, #578843);
  background-image: linear-gradient(to bottom, #79bc64, #578843);
  -webkit-border-radius: 4;
  -moz-border-radius: 4;
  border-radius: 4px;
  text-shadow: 0px 1px 0px #898a88;
  -webkit-box-shadow: 0px 0px 0px #a4e388;
  -moz-box-shadow: 0px 0px 0px #a4e388;
  box-shadow: 0px 0px 0px #a4e388;
  font-family: Arial;
  color: #ffffff;
  font-size: 20px;
  padding: 10px 20px 10px 20px;
  border: solid #3b6e22  1px;
  text-decoration: none;
}

.signup-btn:hover {
  background: #79bc64;
  background-image: -webkit-linear-gradient(top, #79bc64, #5e7056);
  background-image: -moz-linear-gradient(top, #79bc64, #5e7056);
  background-image: -ms-linear-gradient(top, #79bc64, #5e7056);
  background-image: -o-linear-gradient(top, #79bc64, #5e7056);
  background-image: linear-gradient(to bottom, #79bc64, #5e7056);
  text-decoration: none;
}
.navbar-default .navbar-brand{
		color:#fff;
		font-size:30px;
		font-weight:bold;
	}
.form .form-control { margin-bottom: 10px; }
@media (min-width:768px) {
	#home{
		margin-top:50px;
	}
	#home .slogan{
		color: #0e385f;
		line-height: 29px;
		font-weight:bold;
	}
}
 
 </style>
  
<title>Sign Up Today | WalletBuddy</title>
</head>
<body> 
 
 
<nav class="navbar navbar-default navbar-fixed-top text-center">
<div class="container-fluid">
  <div class="navbar-header">
  	<a href="/walletbuddy/" class="navbar-brand"><img style="width:175px;margin-top:-12px;position:absolute;left:50%;margin-left:-80px;" src="./resources/index/mainlogo.png"></a>
  </div></div>
</nav>


 

<c:url var="signupAction" value="./signup/save" ></c:url> 
<div class="container" id="wrap" style="margin-top:120px;">
	  <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form:form id="signupForm" action="${signupAction}" method="post" class="form" role="form" modelAttribute="user">   
                    <div class="row">
                        <div class="col-xs-6 col-md-6">
                            <form:input type="text" path="firstName" name="firstName" value="" class="form-control input-lg" placeholder="First Name"  />                        
                        </div>
                        <div class="col-xs-6 col-md-6">
                            <form:input type="text" path="lastName" name="lastName" value="" class="form-control input-lg" placeholder="Last Name"  />                        
                       </div>
                    </div>
                    <form:input type="text" path="email" name="email" value="" class="form-control input-lg" placeholder="Your Email"  />
                    <form:input type="password" path="password" name="password" value="" class="form-control input-lg" placeholder="Password"  />
                    <form:input type="password" path="" name="confirm_password" value="" class="form-control input-lg" placeholder="Confirm Password"  />                    
                    <br />
              <span class="help-block">By clicking Create my account, you agree to our Terms and that you have read our Data Use Policy, including our Cookie Use.</span>
                    <button class="btn btn-lg btn-primary btn-block signup-btn" type="submit">
                        Create my account</button>
            </form:form>          
</div> </div> </div> </div>  



</body>
</html>