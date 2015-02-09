package com.efrei;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rent {
	private int id;
	private Date begin;
	private Date end;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}	
}
