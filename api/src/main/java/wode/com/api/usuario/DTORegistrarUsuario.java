package wode.com.api.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;

public record DTORegistrarUsuario(
        @NotBlank
        String nombre,
        @NotBlank
        @Pattern(regexp = "^(0[1-9]|1[0-2]):[0-5][0-9] [aApP][mM] - (0[1-9]|1[0-2]):[0-5][0-9] [aApP][mM]$")
        String horario,
        @NotBlank
        String sucursal,
        @NotNull
        Cargo cargo
) {
}
