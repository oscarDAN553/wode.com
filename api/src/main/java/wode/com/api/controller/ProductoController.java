package wode.com.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wode.com.api.producto.DTORegistrarProducto;
import wode.com.api.producto.Producto;
import wode.com.api.producto.ProductoRepository;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired

    private ProductoRepository productoRepository;
    @PostMapping
    public void registrarProducto(@RequestBody @Valid DTORegistrarProducto dtoRegistrarProducto){
        System.out.println(dtoRegistrarProducto);
        productoRepository.save(new Producto(dtoRegistrarProducto));
    }



}
