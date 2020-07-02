<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript" 
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Login</h1>
				<p class="lead">Please enter your username and password below.</p>
			</div>
		</div>
		<form action="Authentication" method="post">
			<label>Username</label>
			&nbsp;&nbsp;
			<input type="text" id="user" name="user">
			<br><br>
			<label>Password</label>
			&nbsp;&nbsp;
			<input type="password" id="pwd" name="pwd">
			<br><span style="color:red;"> ${ message } </span>
			<br><br>
			<input type="submit" value="Login" class="btn btn-primary">
			 <input type="button" value="sign-up" name="sign-up"
    			onclick="openPage('librarian-user-signup.jsp')"/>
    			
    		<script type="text/javascript">
 				function openPage(pageURL)
 					{
 						window.location.href = pageURL;
					 }
			</script>
			
			<script type="text/javascript">
			
		
				$(document).ready(function() {
					$("#loginForm").validate({
						rules: {
							user: {
								required: true,
								user: true
							},
					
							pwd: "required",
						},
						
						messages: {
							user: {
								required: "Please enter your username",
								user: "Please enter a valid username"
							},
							
							pwd: "Please enter your pasword"
						}
					});
				
				});
			</script>
		</form>
	</div>
</body>
</html>
