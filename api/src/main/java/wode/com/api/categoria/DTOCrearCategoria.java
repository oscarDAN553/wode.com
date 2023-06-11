package wode.com.api.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOCrearCategoria(
        @NotBlank
        @Pattern(regexp = "^[A-Za-z]+$")
        String nombre
) {
}
