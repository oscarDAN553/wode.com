package wode.com.api.barcode;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DTORegistrarBarcode(
        @NotNull
        //@Pattern(regexp = "^[1-9]\\d*$") al ser de tipo long no permite la validacion regex
        Long idProducto,
        @NotNull
        //@Pattern(regexp = "^[1-9]\\d*$")
        Long barcode
) {
}
