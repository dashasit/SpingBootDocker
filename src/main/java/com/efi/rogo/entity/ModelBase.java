package com.efi.rogo.entity;

import java.sql.Timestamp;

public class ModelBase {

	private int id;
	private Timestamp created;
	private boolean deleted;
	private Timestamp modified;

	public ModelBase() {

	}

	public ModelBase(int id, Timestamp created, boolean deleted,
			Timestamp modified) {
		super();
		this.id = id;
		this.created = created;
		this.deleted = deleted;
		this.modified = modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Timestamp getModified() {
		return modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

}
