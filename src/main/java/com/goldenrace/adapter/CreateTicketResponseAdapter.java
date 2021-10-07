package com.goldenrace.adapter;

import com.goldenrace.dto.CreateTicketResponseDTO;
import com.goldenrace.model.Ticket;

public class CreateTicketResponseAdapter {
	
	
	public CreateTicketResponseDTO  adapter(Ticket request) {
		CreateTicketResponseDTO createTicket=new CreateTicketResponseDTO();
		createTicket.setIdTicket(request.getId());
		return createTicket;
		
	}

}
