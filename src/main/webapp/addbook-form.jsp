<%@ include file="header.jsp" %>

<div class="container">
	
	<% String formType = "editBook"; %>


	<c:if test="${ book != null }">
		
		<h1>Update book</h1>
	
	</c:if>

	<c:if test="${ book == null }">
		
		<h1>Add new book</h1>
		<% formType = "addBook"; %>
		
	</c:if>



<form action="<%= formType %>" method="get">
  <div class="form-group">
  		<c:if test="${ book != null }">
		<%-- hidden input, won't show up on the page but will pass our ID for the product. --%>
		<input type="hidden" name="id" value="<c:out value="${ book.id }" />" />
		
		</c:if>
  
    <label for="exampleInputEmail1">Title</label>
    <input type="text" class="form-control" name="title" id="title" aria-describedby="bookTitle" placeholder="Book Title">
  </div>
  <div class="form-group">
    <label for="descr">Description</label>
    <input type="text" class="form-control" id="descr" placeholder="Description">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>

<%@ include file="footer.jsp" %>