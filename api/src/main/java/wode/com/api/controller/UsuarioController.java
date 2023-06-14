package wode.com.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wode.com.api.usuario.DTORegistrarUsuario;
import wode.com.api.usuario.Usuario;
import wode.com.api.usuario.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping
    public void crearUsuario (@RequestBody @Valid DTORegistrarUsuario dtoRegistrarUsuario){
        System.out.println(dtoRegistrarUsuario);
        //usuarioRepository.save(new Usuario(dtoRegistrarUsuario));
    }
}
