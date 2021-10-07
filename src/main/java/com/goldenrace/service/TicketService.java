package com.goldenrace.service;

import java.util.Date;


import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.CreateTicketResponseDTO;
import com.goldenrace.dto.GetTicketByIdResponseDTO;
import com.goldenrace.dto.GetTicketByRangeResponseDTO;

public interface TicketService {

	public CreateTicketResponseDTO createTicket(CreateTicketRequestDTO request) ;
	
	public GetTicketByIdResponseDTO getTicketById(String id);

	public GetTicketByRangeResponseDTO getAllTicketsByRange(Date startDate, Date endDate);
	
}
