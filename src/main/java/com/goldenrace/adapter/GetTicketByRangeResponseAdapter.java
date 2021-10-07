package com.goldenrace.adapter;

import java.util.ArrayList;
import java.util.List;

import com.goldenrace.dto.GetTicketByRangeResponseDTO;
import com.goldenrace.dto.TicketDTO;
import com.goldenrace.dto.TicketDetailDTO;
import com.goldenrace.model.Ticket;
import com.goldenrace.model.TicketDetail;

public class GetTicketByRangeResponseAdapter {
   
	public GetTicketByRangeResponseDTO adapter(List<Ticket> tickets) {
		GetTicketByRangeResponseDTO getTicketResponse=new GetTicketByRangeResponseDTO();
		List<TicketDTO> ticketsResponse=new ArrayList<> ();
		
		
		for (Ticket ticket : tickets) {
			TicketDTO ticketDto=new TicketDTO();
			ticketDto.setAmount(ticket.getAmount());
			ticketDto.setId(ticket.getId());
			ticketDto.setCreationDate(ticket.getCreationDate());
			
			List<TicketDetailDTO> ticketDetails=new ArrayList<> ();
			for (TicketDetail ticketD : ticket.getTicketDetail()) {
				TicketDetailDTO ticketDetailsDtp=new TicketDetailDTO();
				ticketDetailsDtp.setAmount(ticketD.getAmount());
				ticketDetailsDtp.setId(ticketD.getId());
				ticketDetailsDtp.setAmount(ticketD.getAmount());
				ticketDetailsDtp.setDescription(ticketD.getDescription());
				ticketDetails.add(ticketDetailsDtp);
			}
	
			ticketDto.setTicketDetail(ticketDetails);
			ticketsResponse.add(ticketDto);
		}
	
		getTicketResponse.setTickets(ticketsResponse);
		return getTicketResponse;
	}
}
