package com.goldenrace.dto;

import java.util.List;

public class GetTicketByRangeResponseDTO {

	private List<TicketDTO> tickets;

	public List<TicketDTO> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketDTO> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "GetTicketByRangeResponseDTO [tickets=" + tickets + "]";
	}

}
