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
import com.cognixia.jump.models.BookCheckout;

public class BookCheckoutDao {
	public static final Connection conn = ConnectionManager.getConnection();
	
	private static String CHECKOUT = "insert into book_checkout(patron_id, isbn, checkedout, due_date, returned) values(?, ?, current_date(), current_date(), null)";
	private static String RETURN = "update book_checkout set returned = ? where checkout_id = ?";
	private static String HISTORY = "select * from book_checkout where patron_id = ? order by due_date desc";
	private static String GET_BOOK_CHECKOUT = "select * from book_checkout where patron_id = ? and isbn = ? and returned = null";
	
	
	public BookCheckout getBookCheckedOut(int user_id, String isbn) {
		BookCheckout book = null;

		try (PreparedStatement pstmt = conn.prepareStatement(GET_BOOK_CHECKOUT)) {
			
			pstmt.setInt(1, user_id);
			pstmt.setString(2, isbn);

			ResultSet rs = pstmt.executeQuery();

			// if product found, if statement run, if not null returned as product
			if (rs.next()) {
				book = new BookCheckout(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDate(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return book;
	}
	
	public boolean checkoutBook(BookCheckout checkout_book) {

		try (PreparedStatement checkout_update_stmt = conn.prepareStatement(CHECKOUT))
		//PreparedStatement book_update_stmt = conn.prepareStatement(UPDATE_BOOK))
		{
			// TODO we can also check if we the book is rented or not here.
			// book_update_stmt.setBoolean(3, book.isRented());
			checkout_update_stmt.setInt(1, checkout_book.getPatronID());
			checkout_update_stmt.setString(2, checkout_book.getIsbn());

			// at least one row added
			if (checkout_update_stmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean returnBook(BookCheckout book) {
		try (PreparedStatement checkout_update_stmt = conn.prepareStatement(RETURN))
		//PreparedStatement book_update_stmt = conn.prepareStatement(UPDATE_BOOK))
		{
			// TODO we can also check if we the book is rented or not here.
			// book_update_stmt.setBoolean(3, book.isRented());
			
			checkout_update_stmt.setDate(1, book.getReturned());
			checkout_update_stmt.setInt(2, book.getCheckOutID());

			// at least one row added
			if (checkout_update_stmt.executeUpdate() > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public List<BookCheckout> getHistory(int id) {
		List<BookCheckout> history = new ArrayList<BookCheckout>();
		try (PreparedStatement pstmt = conn.prepareStatement(HISTORY)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				
				history.add(new BookCheckout(rs.getInt("checkout_id"), rs.getInt("patron_id"), rs.getString("isbn"), rs.getDate("checkedout"), rs.getDate("due_date"), rs.getDate("returned")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return history;
	}
}
