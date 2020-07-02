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
import com.cognixia.jump.models.User;


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
		case "/Login":
			login(request, response);
			break;
		case "/Authentication":
			authentication(request, response);
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
	
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	
	
	private void authentication(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		Librarian librarian = librarianDao.getLibrarianByNameAndPassword(username, password);
		User user = userdao.getPatronByPasswordAndUsername(username, password);
		if(librarian != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("librarian-menu.jsp");
			dispatcher.forward(request, response);
		} else if(user != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-menu.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("add-librarian.jsp");
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