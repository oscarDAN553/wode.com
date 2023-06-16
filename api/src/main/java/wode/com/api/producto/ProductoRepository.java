package wode.com.api.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //@Query("SELECT p FROM Producto p WHERE p.marca LIKE %:keyword% OR p.descripcion LIKE %:keyword%")
    @Query("SELECT p FROM Producto p JOIN Barcode b ON p.id = b.idProducto WHERE p.marca LIKE %:keyword% OR p.descripcion LIKE %:keyword% OR b.barcode LIKE %:keyword% AND p.activo = '1'")
    List<Object> buscarProductos(String keyword);//se uso join para vincular las tablas mediante las columnas producto.id y barcode.idProducto, debe existir el mismo dato id en ambas columnas

    @Query("SELECT p FROM Producto p WHERE p.fechaCaducidad BETWEEN :fechaActual AND :fechaLimite AND p.activo = '1' AND p.cantidad > 0")//si el el campo es de tipo string se debe marcar entre '' simples
    List<Object> listarProximosCaducar(Date fechaActual , Date fechaLimite);

    @Query("SELECT p FROM Producto p WHERE p.cantidad <= 1 AND p.activo = '1'")
    List<Object> listarFaltantes();

    @Query("SELECT p FROM Producto p WHERE p.id = :id")
    Producto findByIdContaining(Long id);
}
