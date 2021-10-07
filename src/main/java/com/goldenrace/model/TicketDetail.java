package com.goldenrace.model;

import java.io.Serializable;

public class TicketDetail  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String idTicket;
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
	public String getIdTicket() {
		return idTicket;
	}
	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}
	@Override
	public String toString() {
		return "TicketDetail [id=" + id + ", idTicket=" + idTicket + ", description=" + description + ", amount="
				+ amount + "]";
	}

	
	
	
	
	
}
