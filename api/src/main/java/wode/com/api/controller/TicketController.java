package wode.com.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wode.com.api.ticket.DTOTicket;
import wode.com.api.ticket.TicketRepository;
import wode.com.api.ticket.Ticket;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Ticket>> listarTickets(){
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Ticket> listaTickets = ticketRepository.listaTickets(localDateTime);
        return ResponseEntity.ok().body(listaTickets);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Ticket> DesactivarTicket(@RequestParam("id") Long id){
        Ticket ticket = ticketRepository.findByIdContaining(id);
        //ticket.desactivarTicket();
        return ResponseEntity.ok().body(ticket);
    }
}
