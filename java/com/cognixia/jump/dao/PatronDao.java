package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Librarian;
import com.cognixia.jump.models.Patron;

public class PatronDao {
	
	public static final Connection conn = ConnectionManager.getConnection();
	
	private static String SELECT_ALL_PATRONS = "select * from patron";
	private static String SELECT_PATRON_BY_ID = "select * from patron where password = ? and username = ?";
	private static String INSERT_PATRON = "insert into patron(first_name, last_name, username, password, account_frozen) values(?, ?, ?, ?, ?)";
	private static String DELETE_PATRON = "delete from patron where id = ?";
	private static String UPDATE_PATRON = "update patron set username = ?, password = ? where id = ?";
	
	public List<Patron> getAllPatrons() {
		
		List<Patron> allPatrons = new ArrayList<Patron>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PATRONS);
				ResultSet rs = pstmt.executeQuery() ) {
			
			while(rs.next()) {
				
				int id = rs.getInt("patron_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String user_name = rs.getString("username");
				long password = rs.getLong("password");
				boolean account_frozen = rs.getBoolean("account_frozen");
				allPatrons.add(new Patron(id, first_name, last_name, user_name, password, account_frozen));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return allPatrons;
	}
	
	public boolean getPatronByPasswordandUsername(String username, String password) {
		
		boolean bool = false;
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_PATRON_BY_ID)) {
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			// if product found, if statement run, if not null returned as product
			if(rs.next()) {
				bool = true;
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return bool;
		
		
	}

	public boolean addPatron(String firstname, String lastname, String username, String password) {
		
		try(PreparedStatement pstmt = conn.prepareStatement(INSERT_PATRON)) {
			
			pstmt.setString(1 , firstname);
			pstmt.setString(2, lastname);
			pstmt.setString(3, username);
			pstmt.setString(4,password);
			
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
}
