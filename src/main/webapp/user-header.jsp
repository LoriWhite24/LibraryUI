<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>

	<header class="container">
		<nav class="nav">
			<a type="button" href="<%= request.getContextPath() %>/CheckoutBooks">Checkout Books</a>
			<a type="button" href="<%= request.getContextPath() %>/ReturnBooks">Return Books</a>
			<a type="button" href="<%= request.getContextPath() %>/ViewmyBooks">View All Books</a>
			<a type="button" href="<%= request.getContextPath() %>/ListofBooks">User history</a>
		</nav>
	</header>