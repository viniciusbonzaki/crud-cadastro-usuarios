package com.javanauta.cadastrousuarios.business.converter;

import com.javanauta.cadastrousuarios.business.dto.UsuarioDTO;
import com.javanauta.cadastrousuarios.infrastructure.entity.Usuario;

import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {
    // Converter de Entity para DTO
    public UsuarioDTO converterParaUsuarioDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .build();
    }

    // Converter de DTO para Entity
    public Usuario converterParaUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .build();
    }

    // Atualizar Dados do Usuario
    public Usuario atualizarDadosUsuario(Usuario usuarioEntity, UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .id(usuarioEntity.getId())
                .nome(usuarioDTO.getNome() != null ? usuarioDTO.getNome() : usuarioEntity.getNome())
                .email(usuarioDTO.getEmail() != null ? usuarioDTO.getEmail() : usuarioEntity.getEmail())
                .build();
    }
}
