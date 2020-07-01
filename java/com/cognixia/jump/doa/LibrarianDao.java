package com.cognixia.jump.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Librarian;

public class LibrarianDao {
	
	public static final Connection conn = ConnectionManager.getConnection();
	
	private static String SELECT_ALL_LIBRARIANS = "select * from librarian";
	private static String SELECT_LIBRARIAN_BY_ID = "select * from librarian where id = ?";
	private static String INSERT_LIBRARIAN = "insert into librarian(username, password) values(?, ?)";
	private static String DELETE_LIBRARIAN = "delete from librarian where id = ?";
	private static String UPDATE_LIBRARIAN = "update librarian set username = ?, password = ? where id = ?";
	
	public List<Librarian> getAllLibrarians() {
		
		List<Librarian> allLibrarians = new ArrayList<Librarian>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_LIBRARIANS);
				ResultSet rs = pstmt.executeQuery() ) {
			
			while(rs.next()) {
				
				int id = rs.getInt("librarian_id");
				String name = rs.getString("username");;
				String password = rs.getString("password");
				allLibrarians.add(new Librarian(id, name, password));
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return allLibrarians;
	}
	
	public Librarian getLibrarianById(int id) {
		
		Librarian product = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_LIBRARIAN_BY_ID)) {
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			// if product found, if statement run, if not null returned as product
			if(rs.next()) {
				String name = rs.getString("name");
				String password = rs.getString("password");
				
				product = new Librarian(id, name, password);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return product;
	}

	public boolean addLibrarian(Librarian librarian) {
		
		try(PreparedStatement pstmt = conn.prepareStatement(INSERT_LIBRARIAN)) {
			
			pstmt.setString(1, librarian.getUsername());
			pstmt.setString(3, librarian.getPassword());
			
			// at least one row added
			if(pstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteLibrarian(int id) {

		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_LIBRARIAN)) {

			pstmt.setInt(1, id);

			// at least one row deleted
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean updateProduct(Librarian librarian) {
		
		try (PreparedStatement pstmt = conn.prepareStatement(UPDATE_LIBRARIAN)) {

			pstmt.setString(1, librarian.getUsername());
			pstmt.setString(2, librarian.getPassword());
			pstmt.setInt(3, librarian.getId());

			// at least one row updated
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
