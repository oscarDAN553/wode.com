package wode.com.api.ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record DTOTicket(

        @NotBlank
        @Pattern(regexp ="^\\d*\\.\\d+$")
        String total,
        @NotNull
        List<Object> listadoProductos
        ) {
}

