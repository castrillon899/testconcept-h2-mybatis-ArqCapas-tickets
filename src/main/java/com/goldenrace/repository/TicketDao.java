package com.goldenrace.repository;

import java.util.Date;
import java.util.List;

import com.goldenrace.model.Ticket;

public interface TicketDao {
	
	List<Ticket> findAll(Date startDate, Date endDate);

	Ticket findTicketById(int id);
	
	void  insertTicket(Ticket ticket);
	



}
