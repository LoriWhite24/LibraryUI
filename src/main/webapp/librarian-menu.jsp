<%@ include file="header.jsp" %>
<body>

<div class="container">
	<h1>Librarian Menu</h1>
	<br>
	<br>
	
<button class="btn btn-primary" type="button" href="<%= request.getContextPath() %>/add">Add New Books</button>
	
	
	<table class="table table-striped">
	
		<thead>
			<tr>
				<th>ISBN</th>
				<th>Book title</th>
				<th>Description</th>
				<th>Availability</th>
				<th>Date added to Library</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="book" items="${ allBooks }">
				<tr>
					<td><c:out value="${ book.isbn }" /></td>
					
					<td><c:out value="${ book.title }" /></td>
					
					<td><c:out value="${ book.description }" /></td>
				<c:choose>
					<c:when test="${ book.rented }">
						<td>Checked out</td>
					</c:when>
					<c:otherwise>
						<td style="color: green">Available</td>
					</c:otherwise>
				</c:choose>
					
					<td><c:out value="${ book.date }"/></td>
					<td>
						<a class="btn btn-primary" href="edit?id=<c:out value='${ book.isbn }' />" >Edit</a>
						<a class="btn btn-danger" href="thankyou?id=<c:out value='${ book.isbn }' />">Return book</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>


</div>


