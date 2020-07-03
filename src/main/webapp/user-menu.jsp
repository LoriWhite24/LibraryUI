<%@ include file="header.jsp" %>

<body>

<div class="container">
	<h1>Patron Menu</h1>
	<br>
	<br>
	
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
					
					<td><c:out value="${ book.dateAddedLibrary }" /></td>
					
					<td><a class="btn btn-primary" href="edit?id=<c:out value='${ book.isbn }' />" >Checkout books</a>
					<a class="btn btn-danger" href="thankyou?id=<c:out value='${ book.isbn }' />">Return book</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>

	<button class="btn btn-primary" type="button" href="<%= request.getContextPath() %>/">Get User History</button>
	
</div>

</body>