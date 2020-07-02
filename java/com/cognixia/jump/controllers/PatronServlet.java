package com.cognixia.jump.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookCheckoutDao;
import com.cognixia.jump.dao.BookDao;
import com.cognixia.jump.dao.Userdao;
import com.cognixia.jump.models.BookCheckout;
import com.cognixia.jump.models.User;





public class PatronServlet extends HttpServlet {



	private static final long serialVersionUID = 1L;
	private User user;
	private Userdao userdao ;
	private BookDao bookdao;
	private BookCheckoutDao bookCheckoutdao;

	public void init() {


		userdao = new Userdao();
		bookdao = new BookDao();
		bookCheckoutdao = new BookCheckoutDao();
	}


	public void destroy() {


		try {

			ConnectionManager.getConnection().close();
		} catch(SQLException e) {

			e.printStackTrace();
		}
	}







	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user");

		String action = request.getServletPath();


		switch(action) {



		case "/delete":
			deletePatron(request, response);
			break;



		case "/update":

			updatePatron(request, response);
			break;
		case "/availableBooks":
			getAvailableBooks(request, response);
			break;
		case "/history":
			getHistory(request, response);
			break;
		case "/checkoutBook":
			checkoutBook(request, response);
			break;
		case "/returnBook":
			returnBook(request, response);
			break;
		default:
			response.sendRedirect("/");

			break;
		}

	}


	private void returnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = (String) request.getAttribute("book.isbn");
		BookCheckout book = bookCheckoutdao.getBookCheckedOut(user.getId(), isbn);
		
		if(book != null) {
			if(bookCheckoutdao.returnBook(book)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("user-menu.jsp");
				dispatcher.forward(request, response);
			} else {
				String message = "Book was not returned.";
				request.setAttribute("message", message);
			}
		} else {
			String message = "Book could not be returned.";
			request.setAttribute("message", message);
		}
		
		
	}


	private void checkoutBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn = (String) request.getAttribute("book.isbn");
		
		BookCheckout book = new BookCheckout(0, user.getId(), isbn, null, null, null);
		
		if(bookCheckoutdao.checkoutBook(book)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-menu.jsp");
			dispatcher.forward(request, response);
		} else {
			String message = "Book was not checked out.";
			request.setAttribute("message", message);
		}
		
	}


	private void getHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	private void getAvailableBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	private void deletePatron(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("patron_id"));

		userdao.deletePatron(id);

		response.sendRedirect("list");
	}


	private void updatePatron (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("patron_id"));
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String userName = request.getParameter("username");
		long password = Integer.parseInt(request.getParameter("password"));

		User patron = new User(id, firstName, lastName, userName, password, false);


		userdao.updatePatron(patron);


		response.sendRedirect("list");

	}



}
