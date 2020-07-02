<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patron Menu</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>

<header class="container">
<button type="button" href="<%= request.getContextPath() %>/CheckoutBooks" > Checkout Books</button>
<button type="button" href="<%= request.getContextPath() %>/ReturnBooks" > Return Books</button>
<button type="button" href="<%= request.getContextPath() %>/ViewmyBooks" > View All Books</button>
<button type="button" href="<%= request.getContextPath() %>/ListofBooks" > List of all Books</button>
</header>


