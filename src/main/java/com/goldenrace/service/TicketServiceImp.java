package com.goldenrace.service;

import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenrace.adapter.CreateTicketResponseAdapter;
import com.goldenrace.adapter.GetTicketByIdResponseAdapter;
import com.goldenrace.adapter.GetTicketByRangeResponseAdapter;
import com.goldenrace.adapter.TicketAdapter;
import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.CreateTicketResponseDTO;
import com.goldenrace.dto.GetTicketByIdResponseDTO;
import com.goldenrace.dto.GetTicketByRangeResponseDTO;
import com.goldenrace.model.Ticket;
import com.goldenrace.repository.TicketDao;

@Service
public class TicketServiceImp implements TicketService {

	@Autowired
	private TicketDao repository;

	@Override
	public CreateTicketResponseDTO createTicket(CreateTicketRequestDTO request) {
		Ticket ticket = new TicketAdapter().adapter(request);
		repository.insertTicket(ticket);
		return new CreateTicketResponseAdapter().adapter(ticket);
	}

	@Override
	public GetTicketByIdResponseDTO getTicketById(int id) {
		Ticket ticket = repository.findTicketById(id);
		if (ticket == null) {
			throw new RuntimeErrorException(null, "sin datos");

		}
		return new GetTicketByIdResponseAdapter().adapter(ticket);
	}

	@Override
	public GetTicketByRangeResponseDTO getAllTicketsByRange(Date startDate, Date endDate) {
		List<Ticket> tickets = repository.findAll(startDate, endDate);
		return new GetTicketByRangeResponseAdapter().adapter(tickets);
	}

}
