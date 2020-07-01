package com.cognixia.jump.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookDao;


@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
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
		// TODO Auto-generated method stub
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
		// TODO 
		
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