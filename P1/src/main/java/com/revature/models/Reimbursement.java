package com.revature.models;

public class Reimbursement {

	private int ID;
	private int author;
	private int resolver;
	private String description;
	private Reimbursement_Type type;
	private Status status;
	private double amount;
	

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub//
	}


	public Reimbursement(int id, int author, int resolver, String description, Reimbursement_Type type,
			Status status, double amount) {
		super();
		this.ID = id;
		this.author = author;
		this.resolver = resolver;
		this.description = description;
		this.type = type;
		this.status = status;
		this.amount = amount;
		
	}


	public int getId() {
		return ID;
	}


	public void setId(int id) {
		this.ID = id;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public int getResolver() {
		return resolver;
	}


	public void setResolver(int resolver) {
		this.resolver = resolver;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Reimbursement_Type getType() {
		return type;
	}


	public void setType(Reimbursement_Type type) {
		this.type = type;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}

}
