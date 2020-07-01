package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Book;


public class BookDao {

	public static final Connection conn = ConnectionManager.getConnection();
	
	//private static String SELECT_ALL_BOOK = "select * from book";
	private static String INSERT_BOOK = "insert into book(title, descr, rented, added_to_kubrart) values(?, ?, ?,?)";
	//private static String DELETE_BOOK = "delete from product where id = ?";
	private static String UPDATE_BOOK = "update product set item = ?, qty = ?, description = ? where id = ?";

public boolean addBook(Book book) {
		
		try(PreparedStatement bstmt = conn.prepareStatement(INSERT_BOOK)) {
			
			bstmt.setString(1, book.getTitle());
			bstmt.setString(2, book.getDescription());
			bstmt.setBoolean(3, book.isRented());
			bstmt.setDate(4, book.getDateAddedLibrary());
			
			// at least one row added
		if(bstmt.executeUpdate() > 0) {
				return true;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

public boolean updateProduct(Book book) {
	
	try (PreparedStatement bstmt = conn.prepareStatement(UPDATE_BOOK)) {

		
		bstmt.setString(1, book.getTitle());
		bstmt.setString(2, book.getDescription());
		bstmt.setBoolean(3, book.isRented());
		bstmt.setDate(4, book.getDateAddedLibrary());
		// at least one row updated
		if (bstmt.executeUpdate() > 0) {
			return true;
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}
	
	
	
	
}
