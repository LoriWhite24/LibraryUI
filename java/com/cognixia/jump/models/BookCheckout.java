package com.cognixia.jump.models;

import java.sql.Date;

public class BookCheckout {
	private int checkOutID;
	private int patronID;
	private String isbn;
	private Date checkOut;
	private Date dueDate;
	private Date returned;
	
	public BookCheckout(int check, int patron, String isbn, Date out, Date due, Date returned) {
		this.checkOutID = check;
		this.patronID = patron;
		this.isbn = isbn;
		this.checkOut = out;
		this.dueDate = due;
		this.returned = returned;
	}

	/**
	 * @return the checkOutID
	 */
	public int getCheckOutID() {
		return checkOutID;
	}

	/**
	 * @param checkOutID the checkOutID to set
	 */
	public void setCheckOutID(int checkOutID) {
		this.checkOutID = checkOutID;
	}

	/**
	 * @return the patronID
	 */
	public int getPatronID() {
		return patronID;
	}

	/**
	 * @param patronID the patronID to set
	 */
	public void setPatronID(int patronID) {
		this.patronID = patronID;
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
	 * @return the checkOut
	 */
	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the returned
	 */
	public Date getReturned() {
		return returned;
	}

	/**
	 * @param returned the returned to set
	 */
	public void setReturned(Date returned) {
		this.returned = returned;
	}

	@Override
	public String toString() {
		return "BookCheckout [checkOutID=" + checkOutID + ", patronID=" + patronID + ", isbn=" + isbn + ", checkOut="
				+ checkOut + ", dueDate=" + dueDate + ", returned=" + returned + "]";
	}
}
