package com.goldenrace.ticket.servicio;

import org.junit.Test;
import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.GetTicketByIdResponseDTO;
import com.goldenrace.dto.GetTicketByRangeResponseDTO;
import com.goldenrace.dto.TicketDTO;
import com.goldenrace.dto.TicketDetailDTO;
import com.goldenrace.exception.BadMessageException;
import com.goldenrace.exception.ResourceNotFoundException;
import com.goldenrace.model.Ticket;
import com.goldenrace.model.TicketDetail;
import com.goldenrace.repository.TicketDao;
import com.goldenrace.service.TicketService;
import com.goldenrace.service.TicketServiceImp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketServiceTest {

	TicketDao ticketDao = mock(TicketDao.class);

	@Test()
	public void crearTicketElValorDelTicketNoSumaLosDetalles() {

		CreateTicketRequestDTO createRequest = new CreateTicketRequestDTO();
		TicketDTO ticket = new TicketDTO();
		ticket.setAmount(12.0);
		ticket.setCreationDate(new Date());
		List<TicketDetailDTO> ticketDetails = new ArrayList<>();

		TicketDetailDTO ticketDetail = new TicketDetailDTO();
		ticketDetail.setDescription("XX");
		ticketDetail.setId("1");
		ticketDetail.setAmount(11.0);
		ticketDetails.add(ticketDetail);

		ticket.setTicketDetail(ticketDetails);
		createRequest.setTicket(ticket);
		// arrage

		TicketService ticketServicio = new TicketServiceImp(ticketDao);

		// action
		try {

			ticketServicio.createTicket(createRequest);

		} catch (Exception e) {

			// assert
			assertTrue(e instanceof BadMessageException);
		}

	}

	@Test()
	public void crearTicketParametrosMandatoriosInvalidos() {

		CreateTicketRequestDTO createRequest = new CreateTicketRequestDTO();
		TicketDTO ticket = new TicketDTO();

		ticket.setCreationDate(new Date());
		List<TicketDetailDTO> ticketDetails = new ArrayList<>();

		TicketDetailDTO ticketDetail = new TicketDetailDTO();
		ticketDetail.setDescription("XX");
		ticketDetail.setId("1");
		ticketDetail.setAmount(11.0);
		ticketDetails.add(ticketDetail);

		ticket.setTicketDetail(ticketDetails);
		createRequest.setTicket(ticket);
		// arrage

		TicketService ticketServicio = new TicketServiceImp(ticketDao);

		// action
		try {

			ticketServicio.createTicket(createRequest);

		} catch (Exception e) {

			// assert
			assertTrue(e instanceof BadMessageException);
		}

	}

	@Test()
	public void crearTicketSinError() {

		CreateTicketRequestDTO createRequest = new CreateTicketRequestDTO();
		TicketDTO ticket = new TicketDTO();
		ticket.setAmount(12.0);
		ticket.setCreationDate(new Date());
		List<TicketDetailDTO> ticketDetails = new ArrayList<>();

		TicketDetailDTO ticketDetail = new TicketDetailDTO();
		ticketDetail.setDescription("XX");
		ticketDetail.setId("1");
		ticketDetail.setAmount(12.0);
		ticketDetails.add(ticketDetail);

		ticket.setTicketDetail(ticketDetails);
		createRequest.setTicket(ticket);
		// arrage

		// action
		TicketService ticketServicio = new TicketServiceImp(ticketDao);
		ticketServicio.createTicket(createRequest);

		// assert
		// Si todo se ejecuta la grabacion fue correcta
		assertTrue(true);

	}

	@Test()
	public void obtenerTodosLosTicketsPorRango() {

		Date startDate = new Date();
		Date endDate = new Date();
		List<Ticket> ticketsArrange = new ArrayList<>();
		Ticket ticket = new Ticket();
		ticket.setAmount(12.0);
		ticket.setCreationDate(new Date());
		List<TicketDetail> ticketDetails = new ArrayList<>();

		TicketDetail ticketDetail = new TicketDetail();
		ticketDetail.setDescription("XX");
		ticketDetail.setId("1");
		ticketDetail.setIdTicket("1");
		ticketDetails.add(ticketDetail);

		ticket.setTicketDetail(ticketDetails);
		ticketsArrange.add(ticket);
		// arrage

		when(ticketDao.findAll(startDate, endDate)).thenReturn(ticketsArrange);

		// action
		TicketService ticketServicio = new TicketServiceImp(ticketDao);
		GetTicketByRangeResponseDTO tickets = ticketServicio.getAllTicketsByRange(startDate, endDate);

		// assert
		// Validamos que contenga tickets
		assertEquals(false, tickets.getTickets().isEmpty());

	}

	@Test()
	public void obtenerTicketPorIdNoExisteRecurso() {

		int id = 1;
		// arrage

		when(ticketDao.findTicketById(id)).thenReturn(null);

		// action
		TicketService ticketServicio = new TicketServiceImp(ticketDao);

		// action
		try {

			ticketServicio.getTicketById(id);

		} catch (Exception e) {

			// assert
			assertTrue(e instanceof ResourceNotFoundException);
		}

	}

	@Test()
	public void obtenerTicketPorIdSinError() {

		int id = 1;
		Ticket ticket = new Ticket();
		ticket.setAmount(12.0);
		ticket.setId("1");
		ticket.setCreationDate(new Date());
		List<TicketDetail> ticketDetails = new ArrayList<>();

		TicketDetail ticketDetail = new TicketDetail();
		ticketDetail.setDescription("XX");
		ticketDetail.setId("1");
		ticketDetail.setIdTicket("1");
		ticketDetails.add(ticketDetail);

		ticket.setTicketDetail(ticketDetails);
		// arrage

		when(ticketDao.findTicketById(id)).thenReturn(ticket);

		// action
		TicketService ticketServicio = new TicketServiceImp(ticketDao);
		GetTicketByIdResponseDTO ticketResult = ticketServicio.getTicketById(id);

		// assert
		// Validamos que contenga un ticket como sersultado
		assertEquals("1", ticketResult.getTicket().getId());

	}

}
