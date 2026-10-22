package com.javanauta.cadastrousuarios.business;

import com.javanauta.cadastrousuarios.business.converter.UsuarioConverter;
import com.javanauta.cadastrousuarios.business.dto.UsuarioDTO;
import com.javanauta.cadastrousuarios.infrastructure.entity.Usuario;
import com.javanauta.cadastrousuarios.infrastructure.exceptions.ConflictException;
import com.javanauta.cadastrousuarios.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.cadastrousuarios.infrastructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    // Injetar a dependencia do UsuarioRepository para realizar as operações
    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    // Método para salvar um Usuário no Banco de Dados
    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        this.emailExiste(usuarioDTO.getEmail());
        Usuario usuario = usuarioConverter.converterParaUsuario(usuarioDTO);
        usuario = usuarioRepository.saveAndFlush(usuario);
        return usuarioConverter.converterParaUsuarioDTO(usuario);
    }

    // Método para encontrar um Usuário por Email
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(
                () -> new ResourceNotFoundException("Erro: Email " + email + " não Encontrado!")
        );
    }

    // Método para deletar um Usuário por Email
    public void deletarUsuarioPorEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }

    // Método para alterar um Usuário por ID
    public UsuarioDTO atualizarUsuarioPorId(Integer id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Erro: Usuário de ID " + id + " não Encontrado!")
        );
        usuario = usuarioConverter.atualizarDadosUsuario(usuario, usuarioDTO);
        return usuarioConverter.converterParaUsuarioDTO(usuarioRepository.save(usuario));
    }

    private void emailExiste(String email) {
        boolean emailExiste = verificarSeEmailExiste(email);

        if (emailExiste) {
            throw new ConflictException("Erro: Email " + email + " já existe!");
        }
    }

    private boolean verificarSeEmailExiste(String email) {
        return usuarioRepository.existsByEmail(email);
    }
}
