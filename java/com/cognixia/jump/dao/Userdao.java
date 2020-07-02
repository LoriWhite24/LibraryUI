package com.cognixia.jump.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Librarian;
import com.cognixia.jump.models.User;





public class Userdao  {
	
	
	public static final Connection conn = ConnectionManager.getConnection();

	private static String DELETE_PATRON = "delete from patron where patron_id = ?";
	private static String DELETE_PATRON_FROM_BOOK_CHECKOUT = "delete from book_checkout where patron_id = ?";
	private static String SELECT_PATRON_BY_ID = "select * from patron where patron_id = ?";
	private static String UPDATE_PATRON = "update patron set first_name = ?, last_name = ?, username = ?, password = ? where patron_id = ?";
	private static String SELECT_ALL_PATRONS = "select * from patron";
	private static String SELECT_PATRON_BY_NAME_AND_PASSWORD = "select * from patron where username = ? and password = ?";
	private static String INSERT_PATRON = "insert into patron(first_name, last_name, username, password, account_frozen) values(?, ?, ?, ?, ?)";

	public List<User> getAllPatrons() {
		
		List<User> allPatrons = new ArrayList<User>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_PATRONS);
				ResultSet rs = pstmt.executeQuery() ) {
			
			while(rs.next()) {
				
				int id = rs.getInt("patron_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String user_name = rs.getString("username");
				long password = rs.getLong("password");
				boolean account_frozen = rs.getBoolean("account_frozen");
				allPatrons.add(new User(id, first_name, last_name, user_name, password, account_frozen));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return allPatrons;
	}
	
	public User getPatronByPasswordAndUsername(String username, String password) {
		
		User user = null;
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_PATRON_BY_NAME_AND_PASSWORD)) {
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			// if product found, if statement run, if not null returned as product
			if(rs.next()) {
				user = new User(rs.getInt("patron_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getLong("password"), rs.getBoolean("account_frozen"));
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
		
	}
	
	public User getPatronById(int id) {
		
		User user = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_PATRON_BY_ID)) {
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			// if product found, if statement run, if not null returned as product
			if(rs.next()) {
				user = new User(rs.getInt("patron_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getLong("password"), rs.getBoolean("account_frozen"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean addPatron(String firstname, String lastname, String username, String password) {
		
		try(PreparedStatement pstmt = conn.prepareStatement(INSERT_PATRON)) {
			
			pstmt.setString(1, firstname);
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
	
	public boolean deletePatron(int patron_id) {
		boolean del = false;
		
		try(PreparedStatement pstmt = conn.prepareStatement(DELETE_PATRON_FROM_BOOK_CHECKOUT)) {
			pstmt.setInt(1, patron_id);

			int deleted = pstmt.executeUpdate();

			if(deleted > 0) {
				del = true;
			}
			pstmt.close();
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		if(del) {
			try (PreparedStatement pstmt = conn.prepareStatement(DELETE_PATRON)) {

				pstmt.setInt(1, patron_id);

				if(pstmt.executeUpdate() > 0) {
					return true;
				}

			} catch (SQLException e){

				e.printStackTrace();

			}
		}
		
		return false;
	}
	
	
	
	
	public boolean updatePatron (User patron) {
		
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_PATRON)) {
			
			pstmt.setString(1, patron.getFirst_name());
			pstmt.setString(2, patron.getLast_name());
			pstmt.setString(3, patron.getUserName());
			pstmt.setLong(4, patron.getPassword());
			
			if (pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
	


}
