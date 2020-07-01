package com.cognixia.jump.models;

import java.sql.Date;

public class Book {

	
	private String isbn;
	private String title;
	private boolean rented;
	private Date added_to_library;
	
	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getAdded_to_library() {
		return added_to_library;
	}

	public void setAdded_to_library(Date added_to_library) {
		this.added_to_library = added_to_library;
	}

	public Book(String isbn, String title, boolean rented, Date added_to_library) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.rented = rented;
		this.added_to_library = added_to_library;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", rented=" + rented + ", added_to_library="
				+ added_to_library + "]";
	}

}
