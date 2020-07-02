<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Librarian Sign-up</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="jumbotron jumbotron-fluid">
			<div class="container">
				<h1 class="display-4">Patron Sign-up</h1>
				<p class="lead">Please enter your information below.</p>
			</div>
		</div>
		<form action="addPatron" method="post">
			<label>first_name</label>
			&nbsp;&nbsp;
			<input type="text" id="fname" name="fname">
			<br><br>
			<label>last_name</label>
			&nbsp;&nbsp;
			<input type="text" id="lname" name="lname">
			<br><br>
			<label>user-name</label>
			&nbsp;&nbsp;
			<input type="text" id="username" name="username">
			<br><br>
			<label>password</label>
			&nbsp;&nbsp;
			<input type="password" id="password" name="password">
			<br><br>
			<input type="submit" value="submit" class="btn btn-primary">
		</form>
	</div>
</body>
</html>