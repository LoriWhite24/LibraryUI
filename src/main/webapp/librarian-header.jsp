<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Librarian Menu</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style type="text/css">	
.libbuttons {
 	color: red;
  	background: white;
  	font-weight: bold;
  	border: 1px solid #900
}
.libbuttons:hover {
  cursor: pointer;
  background-color: Crimson;
  background-position: 0 -24px;
}
</style>

</head>
<body>

<header class="container">
<br><br><br>
<button type="button" class="libbuttons" href="<%= request.getContextPath() %>/add">Add New Books</button>
<br><br>
<button type="button" class="libbuttons" href="<%= request.getContextPath() %>/update">Update Title and Description</button>
<br><br><br>


</header>


