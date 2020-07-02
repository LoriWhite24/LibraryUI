package com.cognixia.jump.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.User;





public class Userdao  {
	
	
	public static final Connection conn = ConnectionManager.getConnection();
	private static String DELETE_PATRON = "delete from patron where patron_id = ?";
	private static String UPDATE_PATRON = "update patron set first_name = ?, last_name = ?, username = ?, password = ? where patron_id = ?";


	
	
	public boolean deletePatron(int patron_id) {
		
		
		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_PATRON)) {
			
			pstmt.setInt(1, patron_id);
			
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch (SQLException e){
			
			e.printStackTrace();
			
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
