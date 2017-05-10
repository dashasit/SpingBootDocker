package com.efi.rogo.entity;

public class Contact {

	private int id;
	private int parentAccount;
	private String firstName;
	private String lastName;
	private String webAccountName;
	private boolean tempFlag;

	public Contact()
	{
		
	}
	
	public Contact(int id, int parentAccount, String webAccountName, boolean tempFlag) {
		super();
		this.id = id;
		this.parentAccount = parentAccount;
		this.webAccountName = webAccountName;
		this.tempFlag = tempFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParentAccount() {
		return parentAccount;
	}

	public void setParentAccount(int parentAccount) {
		this.parentAccount = parentAccount;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getWebAccountName() {
		return webAccountName;
	}

	public void setWebAccountName(String webAccountName) {
		this.webAccountName = webAccountName;
	}

	public boolean isTempFlag() {
		return tempFlag;
	}

	public void setTempFlag(boolean tempFlag) {
		this.tempFlag = tempFlag;
	}

}
