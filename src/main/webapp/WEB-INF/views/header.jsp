<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<style class="cp-pen-styles">

.center {
  text-align: center;
}

/* NAVIGATION */
 
nav ul {
  list-style: none;
  text-align: center;
}
nav ul li {
  display: inline-block;
}
nav ul li a {
  display: block;
  padding: 15px;
  text-decoration: none;
  color: #aaa;
  font-weight: 600; 
  margin: 0 10px;
}
nav ul li a,
nav ul li a:after,
nav ul li a:before {
  transition: all .5s;
}
nav ul li a:hover {
  color: #999999;
  box-shadow:0px 1px 4px rgba(0,0,0,0.8);
}


 

 

/* SHIFT */
nav.shift ul li a {
  position:relative;
  z-index: 1;
}
nav.shift ul li a:hover {
  color: black;
}
nav.shift ul li a:after {
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
  width: 100%;
  height: 1px;
  content: '.';
  color: transparent;
  background: #e6e6e6;
  visibility: none;
  opacity: 0;
  z-index: -1;
}
nav.shift ul li a:hover:after {
  opacity: 1;
  visibility: visible;
  height: 100%; 
}

 

</style>



	<title>Home</title>
</head>
<body>



<nav class="navbar navbar-default navbar-fixed-top text-center shift">
<div class="container-fluid" style="box-shadow:0px 2px 9px rgba(0,0,0,0.2);">
  <div class="navbar-header">
  	<a href="/walletbuddy/" class="navbar-brand"><img style="width:175px;margin-top:-12px;" src="/walletbuddy/resources/index/mainlogo.png"></a>
  </div>

  <div >
	<ul class="nav navbar-nav" >
		<li class="${homePageClass }"><a href="/walletbuddy/transactions">Transactions</a>
		<li class="${analyticsPageClass}"><a href="/walletbuddy/analytics">Analytics</a>
		<li class="${settingsPageClass}"><a href="/walletbuddy/categories">Categories</a> 
		<% if(request.getSession().getAttribute("userRole")!=null && request.getSession().getAttribute("userRole").toString().equals("admin")) {%>
		   <li class="${usersPageClass}"><a href="/walletbuddy/users">Users</a> <% } %>
		
	</ul>
	
	<ul class="nav navbar-nav navbar-right">
		<li>
			${wallet }
		</li>
	    <li><%  if(request.getSession().getAttribute("userImage")!=null && request.getSession().getAttribute("userImage").toString().length()>1) {%>
        	<p><img src="/walletbuddy/user/image/<% out.println( request.getSession().getAttribute("userImage")); %>"  class="img-circle" style="width:63px;position:absolute;margin-left:-60px;margin-top:2px;"/></p>
        	 <%} %>
        </li>
		<li class="dropdown ${profilePageClass}">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="/walletbuddy/user/settings">Settings</a>
				<li><a href="/walletbuddy/logout">Logout</a>
			</ul>
		</li>
	</ul>

  </div>
</div>
</nav>
