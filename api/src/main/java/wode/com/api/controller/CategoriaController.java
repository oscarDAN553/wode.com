package wode.com.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wode.com.api.categoria.Categoria;
import wode.com.api.categoria.CategoriaRepository;
import wode.com.api.categoria.DTOCrearCategoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController{
    @Autowired
    private CategoriaRepository categoriaRepository;
    @PostMapping
    public void crearCategoria(@RequestBody @Valid DTOCrearCategoria dtoCrearCategoria){
        categoriaRepository.save(new Categoria(dtoCrearCategoria));
    }

}
