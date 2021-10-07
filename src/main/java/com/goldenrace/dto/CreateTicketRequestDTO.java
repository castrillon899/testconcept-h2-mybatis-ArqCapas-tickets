package com.goldenrace.dto;

public class CreateTicketRequestDTO {
	
	private TicketDTO ticket;

	public TicketDTO getTicket() {
		return ticket;
	}

	public void setTicket(TicketDTO ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "CreateTicketRequestDTO [ticket=" + ticket + "]";
	}
	
	

}
