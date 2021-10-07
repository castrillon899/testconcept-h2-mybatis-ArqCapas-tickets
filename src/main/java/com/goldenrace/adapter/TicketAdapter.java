package com.goldenrace.adapter;

import java.util.ArrayList;
import java.util.List;

import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.TicketDetailDTO;
import com.goldenrace.model.Ticket;
import com.goldenrace.model.TicketDetail;

public class TicketAdapter {

	public Ticket adapter(CreateTicketRequestDTO request) {

		if (request.getTicket() != null) {

			Ticket ticket = new Ticket();
			ticket.setCreationDate(request.getTicket().getCreationDate());
			ticket.setAmount(request.getTicket().getAmount());

			if (request.getTicket().getTicketDetail() != null) {
			
				List<TicketDetail> ticketsDetails = new ArrayList<>();
			
				for (TicketDetailDTO ticketDetail : request.getTicket().getTicketDetail()) {
					TicketDetail ticketDe = new TicketDetail();
					ticketDe.setDescription(ticketDetail.getDescription());
					ticketDe.setAmount(ticketDetail.getAmount());
					ticketsDetails.add(ticketDe);
				}
											
				ticket.setTicketDetail(ticketsDetails);
			
			}
		
			return ticket;
		}
		return null;

	}
}
