package com.goldenrace.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goldenrace.model.Ticket;
import com.goldenrace.model.TicketDetail;

@Mapper
public interface TicketMapper {

	List<Ticket> findAll(Date startDate, Date endDate);

	Ticket findTicketById(int id);
	
	void  insertTicket(Ticket ticket);
	
	void  insertTicketDetail(List<TicketDetail> ticketDetail);

}
