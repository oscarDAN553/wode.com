package wode.com.api.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.fecha <= :fechaActual AND t.activo = '1' ")
    List<Ticket> listaTickets(LocalDateTime fechaActual);
    @Query("SELECT t FROM Ticket t WHERE t.id = :id")
    Ticket findByIdContaining(Long id);
}
