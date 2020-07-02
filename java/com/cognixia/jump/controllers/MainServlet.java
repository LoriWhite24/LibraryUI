package com.cognixia.jump.controllers;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.*;
import com.cognixia.jump.models.Librarian;


@WebServlet("/")
public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 275L;
	Userdao userdao;
	LibrarianDao librarianDao;

	
	public void init() {
		 userdao = new Userdao();
		 librarianDao = new LibrarianDao();
		
		
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
		case "/PatronLogin":
			patronLogin(request, response);
			break;
		case "/LibrarianLogin":
			librarianLogin(request, response);
			break;
		case "/AuthenticationLibrarian":
			authenticationLibrarian(request, response);
			break;
		case "/AuthenticationPatron":
			authenticationPatron(request, response);
			break;
		case "/addPatron":
			addPatron(request, response);
			break;
		case "/addLibrarian":
			addLibrarian(request, response);
			break;
			
		default:
			
			response.sendRedirect("/");
			break;
		}
			
	}
	
	private void patronLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-login.jsp");
		dispatcher.forward(request, response);
	}
	

	private void librarianLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("librarian-login.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void authenticationLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("pwd");
		if(librarianDao.getLibrarianByNameAndPassword(user, password)!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("librarian-menu.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("add-Librarian.jsp");
			dispatcher.forward(request, response);
			
	    } 
	}
	
	private void authenticationPatron(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user").trim();
		String password = request.getParameter("pwd").trim();

		if(userdao.getPatronByPasswordAndUsername(user, password)!=null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-menu.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("add-user.jsp");
			dispatcher.forward(request, response);
	    }
		
	}
	
	private void addPatron(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		userdao.addPatron(firstname, lastname, username, password);
		response.sendRedirect("PatronLogin");
		
		
	}
	private void addLibrarian(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		librarianDao.addLibrarian(new Librarian(0, username, password));
		response.sendRedirect("LibrarianLogin");

	
	}
}