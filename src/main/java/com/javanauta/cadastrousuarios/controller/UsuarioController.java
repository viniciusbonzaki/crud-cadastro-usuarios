package com.javanauta.cadastrousuarios.controller;

import com.javanauta.cadastrousuarios.business.UsuarioService;
import com.javanauta.cadastrousuarios.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    // Injetar a dependência da UsuárioService
    private final UsuarioService usuarioService;

    // POST - Adicionar um Usuário
    @PostMapping
    public ResponseEntity<Void> gravarUsuarios(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    // GET - Buscar um Usuário
    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    // DELETE - Remover um Usuário
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam("email") String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    // PUT - Alterar um Usuário
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorId(@RequestParam("id") Integer id,
                                                      @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }
}
