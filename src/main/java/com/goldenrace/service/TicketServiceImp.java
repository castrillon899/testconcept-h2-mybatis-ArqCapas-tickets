package com.goldenrace.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenrace.adapter.GetTicketByIdResponseAdapter;
import com.goldenrace.adapter.GetTicketByRangeResponseAdapter;
import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.CreateTicketResponseDTO;
import com.goldenrace.dto.GetTicketByIdResponseDTO;
import com.goldenrace.dto.GetTicketByRangeResponseDTO;
import com.goldenrace.model.Ticket;
import com.goldenrace.repository.TicketMapper;

@Service
public class TicketServiceImp implements TicketService {

	@Autowired
	private TicketMapper ticketMapper;

	@Override
	public CreateTicketResponseDTO createTicket(CreateTicketRequestDTO request) {
		return null;
	}

	@Override
	public GetTicketByIdResponseDTO getTicketById(String id) {
		Ticket ticket = ticketMapper.findTicketById();
		return new GetTicketByIdResponseAdapter().adapter(ticket);
	}

	@Override
	public GetTicketByRangeResponseDTO getAllTicketsByRange(Date startDate, Date endDate) {
		List<Ticket> tickets = ticketMapper.findAll();
		return new GetTicketByRangeResponseAdapter().adapter(tickets);
	}

}
