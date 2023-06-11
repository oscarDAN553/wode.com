package wode.com.api.producto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTORegistrarProducto(
        @NotBlank
        String marca,
        String descripcion,
        @NotBlank
        String contenido,
        @NotBlank
        @Pattern(regexp ="^\\d*\\.\\d+$")//solo numeros enteros o con punto decimal
        String precioCompra,
        @NotBlank
        @Pattern(regexp ="^\\d*\\.\\d+$")//solo numeros enteros o con punto decimal
        String precioVenta,
        @NotBlank
        @Pattern(regexp = "^[1-9]\\d*$")//solo numeros enteros positivos
        String cantidad,
        @NotBlank
        @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")//fecha en formato YYYY/MM/DD
        String fechaCaducidad,
        @NotBlank
        String ubicacion,
        @NotBlank
        String categoria


) {
}
