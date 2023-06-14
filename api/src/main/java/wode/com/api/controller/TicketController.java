package wode.com.api.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wode.com.api.ticket.DTOTicket;
import wode.com.api.ticket.TicketRepository;
import wode.com.api.ticket.Ticket;

@RestController
@RequestMapping("/tiket")
public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    @PostMapping
    public void RegistrarTiketDeVenta (@RequestBody @Valid DTOTicket dtoTiket){
        System.out.println(dtoTiket);
        ticketRepository.save(new Ticket(dtoTiket));
    }
}
