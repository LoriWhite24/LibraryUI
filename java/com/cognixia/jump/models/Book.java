package com.cognixia.jump.models;

import java.sql.Date;

public class Book {

	private String isbn;
	private String title;
<<<<<<< HEAD
=======


>>>>>>> 4ec73127e2fd4d681d59c8dffc07d0e97b72ea12
	private String description;
	private boolean rented;
	private Date dateAddedLibrary;
	
	public Book(String isbn, String title, String des, boolean rented, Date add) {
		this.isbn = isbn;
		this.title = title;
		this.description = des;
		this.rented = rented;
		this.dateAddedLibrary = add;
<<<<<<< HEAD
=======

>>>>>>> 4ec73127e2fd4d681d59c8dffc07d0e97b72ea12
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

<<<<<<< HEAD
=======

>>>>>>> 4ec73127e2fd4d681d59c8dffc07d0e97b72ea12
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the rented
	 */
<<<<<<< HEAD
=======

>>>>>>> 4ec73127e2fd4d681d59c8dffc07d0e97b72ea12
	public boolean isRented() {
		return rented;
	}

	/**
	 * @param rented the rented to set
	 */
	public void setRented(boolean rented) {
		this.rented = rented;
	}

	/**
	 * @return the dateAddedLibrary
	 */
	public Date getDateAddedLibrary() {
		return dateAddedLibrary;
	}

	/**
	 * @param dateAddedLibrary the dateAddedLibrary to set
	 */
	public void setDateAddedLibrary(Date dateAddedLibrary) {
		this.dateAddedLibrary = dateAddedLibrary;
	}

<<<<<<< HEAD
=======


>>>>>>> 4ec73127e2fd4d681d59c8dffc07d0e97b72ea12
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", description=" + description + ", rented=" + rented
				+ ", dateAddedLibrary=" + dateAddedLibrary + "]";
<<<<<<< HEAD
=======

>>>>>>> 4ec73127e2fd4d681d59c8dffc07d0e97b72ea12
	}
}
