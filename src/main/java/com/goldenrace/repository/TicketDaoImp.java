package com.goldenrace.repository;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import com.goldenrace.model.Ticket;
import com.goldenrace.model.TicketDetail;

@Component
public class TicketDaoImp implements TicketDao {

	
	private TicketMapper repository;
	
	public TicketDaoImp ( TicketMapper repository) {
		this.repository=repository;
		
	}

	@Override
	public List<Ticket> findAll(Date startDate, Date endDate) {
		List<Ticket> tickets = repository.findAll(startDate, endDate);
		return tickets;
	}

	@Override
	public Ticket findTicketById(int id) {
		Ticket ticket = repository.findTicketById(id);
		return ticket;
	}

	@Override
	public void insertTicket(Ticket ticket) {
		repository.insertTicket(ticket);

		if (ticket.getTicketDetail() != null) {
			for (TicketDetail iterable_element : ticket.getTicketDetail()) {
				iterable_element.setIdTicket(ticket.getId());
			}
			repository.insertTicketDetail(ticket.getTicketDetail());
		}
	}

}
