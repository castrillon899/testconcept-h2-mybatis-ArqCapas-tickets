package com.goldenrace.domain;

public class TicketDetail {

	private String id;
	private String description;
	private Double amount;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "TicketDetail [id=" + id + ", description=" + description + ", amount=" + amount + "]";
	}
	
	
	
	
}
