package wode.com.api.barcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTORegistrarBarcode(
        @NotNull
        //@Pattern(regexp = "^[1-9]\\d*$")
        Long idProducto,
        @NotBlank
        @Pattern(regexp = "^[1-9]\\d*$")
        String barcode
) {
}
