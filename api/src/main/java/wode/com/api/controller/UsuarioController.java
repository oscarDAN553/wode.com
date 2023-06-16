package wode.com.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wode.com.api.ticket.Ticket;
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
        usuarioRepository.save(new Usuario(dtoRegistrarUsuario));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<Usuario> DesactivarUsuario(@RequestParam("id") Long id){
        System.out.println(id);
        Usuario usuario = usuarioRepository.findByIdContaining(id);
        usuario.desactivarUsuario();
        return ResponseEntity.ok().body(usuario);
    }
}
