package com.goldenrace.dto;

public class CreateTicketResponseDTO {

	private String idTicket;

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
		
		
	}

	@Override
	public String toString() {
		return "CreateTicketResponseDTO [idTicket=" + idTicket + "]";
	}
	
	
	
}
