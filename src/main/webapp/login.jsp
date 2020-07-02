<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Login</h1>
				<p class="lead">Please enter username and password below.</p>
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
			<br><br>
			<input type="submit" value="Login" class="btn btn-primary">
		</form>
	</div>
</body>
</html>