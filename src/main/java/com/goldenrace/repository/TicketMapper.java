package com.goldenrace.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goldenrace.model.Ticket;

@Mapper
public interface  TicketMapper {
	
	 List<Ticket> findAll();
	 
	 Ticket findTicketById();

}
