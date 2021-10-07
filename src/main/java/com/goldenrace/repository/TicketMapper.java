package com.goldenrace.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goldenrace.model.Ticket;

@Mapper
public interface TicketMapper {

	List<Ticket> findAll(Date startDate, Date endDate);

	Ticket findTicketById(int id);

}
