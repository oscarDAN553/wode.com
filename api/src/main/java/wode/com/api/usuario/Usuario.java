package wode.com.api.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String horario;
    private String sucursal;
    @Enumerated
    private Cargo cargo;
    private String activo;

    public Usuario(DTORegistrarUsuario dtoRegistrarUsuario) {
        this.nombre = dtoRegistrarUsuario.nombre().toLowerCase();
        this.horario = dtoRegistrarUsuario.horario().toLowerCase();
        this.sucursal = dtoRegistrarUsuario.sucursal().toLowerCase();
        this.cargo = Cargo.valueOf(dtoRegistrarUsuario.cargo().toUpperCase());
        this.activo = "1";
    }
}
