package com.javanauta.cadastrousuarios.controller;

import com.javanauta.cadastrousuarios.business.UsuarioService;
import com.javanauta.cadastrousuarios.business.dto.UsuarioDTO;
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
    public ResponseEntity<UsuarioDTO> gravarUsuarios(@RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDTO));
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
    public ResponseEntity<UsuarioDTO> atualizarUsuarioPorId(@RequestParam("id") Integer id,
                                                            @RequestBody UsuarioDTO usuarioDTO) {
       return ResponseEntity.ok(usuarioService.atualizarUsuarioPorId(id, usuarioDTO));
    }
}
