package com.goldenrace.service;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.goldenrace.adapter.CreateTicketResponseAdapter;
import com.goldenrace.adapter.GetTicketByIdResponseAdapter;
import com.goldenrace.adapter.GetTicketByRangeResponseAdapter;
import com.goldenrace.adapter.TicketAdapter;
import com.goldenrace.dto.CreateTicketRequestDTO;
import com.goldenrace.dto.CreateTicketResponseDTO;
import com.goldenrace.dto.GetTicketByIdResponseDTO;
import com.goldenrace.dto.GetTicketByRangeResponseDTO;
import com.goldenrace.exception.BadMessageException;
import com.goldenrace.exception.ResourceNotFoundException;
import com.goldenrace.model.Ticket;
import com.goldenrace.repository.TicketDao;

@Service
public class TicketServiceImp implements TicketService {

	private TicketDao repository;

	public TicketServiceImp(TicketDao repository) {
		this.repository = repository;
	}

	@Override
	public CreateTicketResponseDTO createTicket(CreateTicketRequestDTO request) {
		validateMessage(request);
		Ticket ticket = new TicketAdapter().adapter(request);
		repository.insertTicket(ticket);
		return new CreateTicketResponseAdapter().adapter(ticket);
	}



	@Override
	public GetTicketByIdResponseDTO getTicketById(int id) {
		Ticket ticket = repository.findTicketById(id);
		if (ticket == null) {
			throw new ResourceNotFoundException("No se encontraron resultados para el id: " + id);

		}
		return new GetTicketByIdResponseAdapter().adapter(ticket);
	}

	@Override
	public GetTicketByRangeResponseDTO getAllTicketsByRange(Date startDate, Date endDate) {
		List<Ticket> tickets = repository.findAll(startDate, endDate);
		return new GetTicketByRangeResponseAdapter().adapter(tickets);
	}
	
	private void validateMessage(CreateTicketRequestDTO request) {
		if (request.getTicket() == null) {
			throw new BadMessageException("La solicitud enviada es invalida revise parametros de entrada ");
		}

		if (request.getTicket().getAmount() == null || request.getTicket().getCreationDate() == null
				|| request.getTicket().getTicketDetail() == null

		) {
			throw new BadMessageException(
					"La solicitud enviada no cumple con los parametros obligatorios necesarios para la transaccion ");
		}

	   if(request.getTicket().getAmount()!=  request.getTicket().getTicketDetail().stream().mapToDouble(i->i.getAmount()).sum())
	   {
		   throw new BadMessageException(
					"El valor del ticket no suma el valor de los detalles valide los montos");
	   }
		   
		
	}

}
