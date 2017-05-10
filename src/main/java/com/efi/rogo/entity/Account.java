package com.efi.rogo.entity;

public class Account {

	private int id;
	private String accountId;
	private String title;
	private String status;
	private String type;
	private boolean walkIn;
	public Contact contact;
	private boolean isdeleted;

	public Account() {

	}

	public Account(int id, String accountId, String title, String status,
			String type, boolean walkIn, Contact contact, boolean isdeleted) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.title = title;
		this.status = status;
		this.type = type;
		this.walkIn = walkIn;
		this.contact = contact;
		this.isdeleted = isdeleted;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isWalkIn() {
		return walkIn;
	}

	public void setWalkIn(boolean walkIn) {
		this.walkIn = walkIn;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

}
