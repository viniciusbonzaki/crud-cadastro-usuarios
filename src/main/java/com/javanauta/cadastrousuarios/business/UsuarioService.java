package com.javanauta.cadastrousuarios.business;

import com.javanauta.cadastrousuarios.infrastructure.entity.Usuario;
import com.javanauta.cadastrousuarios.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.cadastrousuarios.infrastructure.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    // Injetar a dependencia do UsuarioRepository para realizar as operações
    private final UsuarioRepository usuarioRepository;

    // Método para salvar um Usuário no Banco de Dados
    public void salvarUsuario(Usuario usuario) {
        usuarioRepository.saveAndFlush(usuario);
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
    public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        // Encontrar o Usuário à ser alterado
        Usuario usuarioEntity = usuarioRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Erro: Usuário de ID " + id + " não Encontrado!")
        );

        // Construir o novo Usuário
        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .build();

        // Salvar a alteração de Dados
        usuarioRepository.save(usuarioAtualizado);
    }
}
