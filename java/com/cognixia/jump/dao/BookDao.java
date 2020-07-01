package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.models.Book;


public class BookDao {

	public static final Connection conn = ConnectionManager.getConnection();
	
	private static String INSERT_BOOK = "insert into book(isbn, title, descr, rented, added_to_library) values(?, ?, ?, ?, current_date())";
	private static String DELETE_BOOK = "delete from book where isbn = ?";
	private static String UPDATE_BOOK = "update book set title = ?, descr = ?, rented = ?, added_to_library = ? where isbn = ?";
	private static String SELECT_BOOK_BY_ISBN = "select * from book where isbn = ?";
	private static String SELECT_ALL_BOOKS = "select * from book";
	
	public Book getBookByISBN(String isbn) {
		
		Book book = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_BOOK_BY_ISBN)) {
			
			pstmt.setString(1, isbn);
			
			ResultSet rs = pstmt.executeQuery();
			
			// if product found, if statement run, if not null returned as product
			if(rs.next()) {
				String title = rs.getString("title");
				String descr = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date added_to_library = rs.getDate("added_to_library");
				
				book = new Book(isbn, title, descr, rented, added_to_library);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return book;
	}
	
	public boolean addBook(Book book) {

		try(PreparedStatement bstmt = conn.prepareStatement(INSERT_BOOK)) {
			
			bstmt.setString(1, book.getIsbn());
			bstmt.setString(2, book.getTitle());
			bstmt.setString(3, book.getDescription());
			bstmt.setBoolean(4, book.isRented());

			// at least one row added
			if(bstmt.executeUpdate() > 0) {
				return true;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updateBook(Book book) {

		try (PreparedStatement bstmt = conn.prepareStatement(UPDATE_BOOK)) {


			bstmt.setString(1, book.getTitle());
			bstmt.setString(2, book.getDescription());
			bstmt.setBoolean(3, book.isRented());
			bstmt.setDate(4, book.getDateAddedLibrary());
			bstmt.setNString(5, book.getIsbn());
			// at least one row updated
			if (bstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deleteBook(String isbn) {

		try (PreparedStatement pstmt = conn.prepareStatement(DELETE_BOOK)) {

			pstmt.setString(1, isbn);

			// at least one row deleted
			if (pstmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public List<Book> getAllBooks () {

		// create a list of books


		List<Book> allBooks = new ArrayList<Book>();

		try(PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_BOOKS);
				ResultSet rs = pstmt.executeQuery() ) {

			while(rs.next()) {

				String isbn = rs.getString("isbn");
				String title = rs.getString("title");
				String descr = rs.getString("descr");
				boolean rented = rs.getBoolean("rented");
				Date added_to_library = rs.getDate("added_to_library");


				allBooks.add(new Book(isbn, title, descr, rented, added_to_library));
			}


		} catch(SQLException e) {

			e.printStackTrace();
		}

		return allBooks;

	}
	
	
}
