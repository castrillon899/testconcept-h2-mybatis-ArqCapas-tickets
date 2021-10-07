package com.goldenrace.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.CreateTicketResponseDTO;
import com.goldenrace.dto.GetTicketByIdResponseDTO;
import com.goldenrace.dto.GetTicketByRangeResponseDTO;
import com.goldenrace.service.TicketService;

/**
 * Interfaz que permite el registro y consulta de tickets
 * 
 * @Autor angel Marin
 *
 */
@RestController
@RequestMapping("ticket")
public class TicketController {

	TicketService ticketService;

	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@PostMapping(path = "/")
	public ResponseEntity<CreateTicketResponseDTO> createTicket(@RequestBody CreateTicketRequestDTO body) {
		
		CreateTicketResponseDTO response = ticketService.createTicket(body);
		return new ResponseEntity<CreateTicketResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/getTicketById")
	public ResponseEntity<GetTicketByIdResponseDTO> getTicketById(@RequestParam("id") int id) {
	
		GetTicketByIdResponseDTO response = ticketService.getTicketById(id);
		return new ResponseEntity<GetTicketByIdResponseDTO>(response, HttpStatus.OK);
	}

	@GetMapping(path = "/getTicketByRange")
	public ResponseEntity<GetTicketByRangeResponseDTO> getAllTicketsByRange(@RequestParam("startDate") Date startDate,
			@RequestParam("endDate") Date endDate) {
		
		GetTicketByRangeResponseDTO response = ticketService.getAllTicketsByRange(startDate, endDate);
		return new ResponseEntity<GetTicketByRangeResponseDTO>(response, HttpStatus.OK);
	}

}
