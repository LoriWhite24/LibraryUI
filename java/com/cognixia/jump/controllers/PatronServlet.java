package com.cognixia.jump.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.Userdao;
import com.cognixia.jump.models.User;





public class PatronServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = 1L;
       
	private Userdao userdao ;
	
	public void init() {
		
		
		userdao = new Userdao();
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
		
		
String action = request.getServletPath();
		
		
		switch(action) {
		
		
			
		case "/delete":
			deletePatron(request, response);
			break;
			
		
			
		case "/update":
			
			updatePatron(request, response);
			break;
			
			default:
				response.sendRedirect("/");
				
				break;
		}
		
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
