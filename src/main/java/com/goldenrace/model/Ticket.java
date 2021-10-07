package com.goldenrace.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Ticket  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date creationDate; 
    private Double amount;   
    List<TicketDetail> ticketDetail;
    
    
	public List<TicketDetail> getTicketDetail() {
		return ticketDetail;
	}

	public void setTicketDetail(List<TicketDetail> ticketDetail) {
		this.ticketDetail = ticketDetail;
	}



	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", creationDate=" + creationDate + ", amount=" + amount + ", ticketDetail="
				+ ticketDetail + "]";
	}



	

	
	
}
