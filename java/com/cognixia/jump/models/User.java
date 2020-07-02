package com.cognixia.jump.models;

public class User  {
	
	private int patron_id;
	
	private String first_name;
	
	private String last_name;
	
	private String userName;
	
	private long password;
	
	boolean accountFrozen;

	public User(int patron_id, String first_name, String last_name, String userName, long password, boolean accountFrozen) {
		
		this.patron_id = patron_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.userName = userName;
		this.password = password;
		this.accountFrozen = accountFrozen;
	}

	public int getId() {
		return patron_id;
	}

	public void setId(int id) {
		this.patron_id = patron_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getPassword() {
		return password;
	}

	public void setPassword(long password) {
		this.password = password;
	}

	public boolean isAccountFrozen() {
		return accountFrozen;
	}

	public void setAccountFrozen(boolean accountFrozen) {
		this.accountFrozen = accountFrozen;
	}

	@Override
	public String toString() {
		return "User [id=" + patron_id + ", first_name=" + first_name + ", last_name=" + last_name + ", userName=" + userName
				+ ", password=" + password + ", accountFrozen=" + accountFrozen + "]";
	}
	
	
	

}
