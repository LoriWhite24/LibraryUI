
<%@ include file="header.jsp" %>

<div class="container">
	
	<h1>List of Books</h1>
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
				<td>
					<c:out value="${ book.isbn }" />
				</td>
				<td>
					<c:out value="${ book.title }" />
				</td>
				<td>
					<c:out value="${ book.description }" />
				</td>
				<td>
					<c:out value="${ book.rent }" />
				</td>
				<td>
					<c:out value="${ book.date }" />
				</td>
				<td>
					<a class="btn btn-primary" href="edit?id=<c:out value='${ book.isbn }' />" >Edit</a>
					<!--  -<a class="btn btn-danger" href="delete?id=<c:out value='${ book.isbn }' />">Delete</a> -->
				</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
	

</div>


<%@ include file="footer.jsp" %>