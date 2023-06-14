package wode.com.api.ticket;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Table(name = "tickets")
@Entity(name = "Ticket")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String total;
    private String listadoProductos;
    private String activo;

    public Ticket(DTOTicket dtoTiket) {
        this.fecha = LocalDateTime.now();
        this.total = dtoTiket.total();
        this.listadoProductos = dtoTiket.listadoProductos().toString();
        this.activo = "1";
    }
}
