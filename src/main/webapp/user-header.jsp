<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patron Menu</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style type="text/css">	
.patbuttons {
 	color: blue;
  	background: white;
  	font-weight: bold;
  	border: 1px solid #900
}
.patbuttons:hover {
  cursor: pointer;
  background-color: PowderBlue;
  background-position: 0 -24px;
}
</style>
</head>
<body>

<header class="container">
<br><br><br>
<button type="button" class="patbuttons" href="<%= request.getContextPath() %>/CheckoutBooks" > Checkout Books</button>
<br><br>
<button type="button" class="patbuttons" href="<%= request.getContextPath() %>/ReturnBooks" > Return Books</button>
<br><br>
<button type="button" class="patbuttons" href="<%= request.getContextPath() %>/ViewmyBooks" > View All Books</button>
<br><br>
<button type="button" class="patbuttons" href="<%= request.getContextPath() %>/ListofBooks" > List of all Books</button>
</header>


