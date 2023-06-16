package wode.com.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wode.com.api.producto.DTORegistrarProducto;
import wode.com.api.producto.DTOBuscarProducto;
import wode.com.api.producto.Producto;
import wode.com.api.producto.ProductoRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;
    @PostMapping
    public void registrarProducto(@RequestBody @Valid DTORegistrarProducto dtoRegistrarProducto){
        productoRepository.save(new Producto(dtoRegistrarProducto));
    }

    @GetMapping
    public ResponseEntity<List<Object>> buscarProducto(@RequestParam("keyword") String keyword){
        List<Object> productos = productoRepository.buscarProductos(keyword);
        return ResponseEntity.ok().body(productos);
    }

    @GetMapping("/caducar")
    public ResponseEntity<List<Object>> listarProximosCaducar(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaLimite){

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zonaHoraria = ZoneId.systemDefault();// Obtener la zona horaria predeterminada
        Date fechaActual = Date.from(localDateTime.atZone(zonaHoraria).toInstant());// Convertir LocalDateTime a Instant// y luego a Date

        List<Object> proximosCaducar = productoRepository.listarProximosCaducar(fechaActual,fechaLimite);
        return ResponseEntity.ok().body(proximosCaducar);
    }

    @GetMapping("/faltantes")
    public ResponseEntity<List<Object>> listarFltantes(){
        List<Object> listaFaltantes = productoRepository.listarFaltantes();
        return ResponseEntity.ok().body(listaFaltantes);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Producto> VentaProducto(@RequestBody DTOBuscarProducto dtoBuscarProducto){
        Producto producto = productoRepository.findByIdContaining(dtoBuscarProducto.id());
        producto.actualizarCantidad(dtoBuscarProducto);
        return ResponseEntity.ok().body(producto);
    }

    @DeleteMapping
    @Transactional
    public  ResponseEntity<Producto> DesactivarProducto(@RequestParam("id") Long id) {
        Producto producto = productoRepository.findByIdContaining(id);
        producto.desactivarProducto();
        return ResponseEntity.ok().body(producto);
    }







}
