
package com.cognixia.jump.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookDao;
//import com.cognixia.jump.model.Product;
import com.cognixia.jump.models.Book;

public class LibrarianServlet extends HttpServlet {

	private static final long serialVersionUID = 1612661432892920935L;
	private BookDao bookDao;

	public void init() {
		bookDao = new BookDao();
	}

	public void destroy() {

		try {
			ConnectionManager.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		
//		case "/delete":
//			deleteProduct(request, response);
//			break;
//		case "/edit":
//			goToEditBookForm(request, response);
//			break;
		case "/update":
			updateBook(request, response);
			break;
//		case "/new":
//			goToNewProductForm(request, response);
//			break;
		case "/add":
			addNewBook(request, response);
			break;

		default:

			response.sendRedirect("/");
			break;
		}
	}

	private void addNewBook(HttpServletRequest request, HttpServletResponse response) {
		
		String isbn = request.getParameter("isbn").trim();
		String title = request.getParameter("title").trim();
		String des = request.getParameter("des").trim();
		boolean rented = Boolean.parseBoolean(request.getParameter("rented").trim());
		//Date add = Date.valueOf("add");

		Book book = new Book(isbn, title, des, rented, null);

		bookDao.addBook(book);
		
		// redirect to our list products page once we finish updating info on product
		try {
			response.sendRedirect("books");
		} catch (IOException e) {
			
			e.printStackTrace();
		}


		
	}

	private void updateBook(HttpServletRequest request, HttpServletResponse response) {
		// grab info to do update for product submitted by form
		int isbn = Integer.parseInt(request.getParameter("isbn").trim());
		String title = request.getParameter("title").trim();
		String descr = request.getParameter("descr").trim();
		boolean rented = Boolean.parseBoolean(request.getParameter("rented"));
		
		// create the product object
		//Book product = new Book();
		
		// pass object to update from the dao
		//productDao.updateProduct(product);
		
		// redirect to our list products page once we finish updating info on product
		//response.sendRedirect("list");
		
	}

}
