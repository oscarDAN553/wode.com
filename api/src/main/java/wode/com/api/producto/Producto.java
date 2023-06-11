package wode.com.api.producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Table(name = "productos")
@Entity(name = "Producto")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String descripcion;
    private String contenido;
    private String precioCompra;
    private String precioVenta;
    private String cantidad;
    private String fechaCaducidad;
    private String ubicacion;
    private String categoria;
    private String actualizar;
    private String activo;

    public Producto(DTORegistrarProducto dtoRegistrarProducto) {
        this.marca = dtoRegistrarProducto.marca().toLowerCase();
        if (dtoRegistrarProducto.descripcion()== null || dtoRegistrarProducto.descripcion().isBlank()) {
            this.descripcion = "Sin descripcion";
        } else {
            this.descripcion = dtoRegistrarProducto.descripcion().toLowerCase();
        }
        this.contenido = dtoRegistrarProducto.contenido().toLowerCase();
        this.precioCompra = dtoRegistrarProducto.precioCompra();
        this.precioVenta = dtoRegistrarProducto.precioVenta();
        this.cantidad = dtoRegistrarProducto.cantidad();
        this.fechaCaducidad = dtoRegistrarProducto.fechaCaducidad();
        this.ubicacion = dtoRegistrarProducto.ubicacion().toLowerCase();
        this.categoria = dtoRegistrarProducto.categoria().toLowerCase();
        this.actualizar = "0";
        this.activo = "1";
    }
}
