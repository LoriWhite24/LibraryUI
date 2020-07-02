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
<body>
<header class="container">
<nav class="nav">
  <a class="nav-link active" href="<%= request.getContextPath() %>/">Home</a>
  <a class="nav-link" href="<%= request.getContextPath() %>/">Patron</a>
  <a class="nav-link" href="<%= request.getContextPath() %>/">Librarian</a>
  <a class="nav-link" href="<%= request.getContextPath() %>/">Catalog</a>
</nav>
</header>