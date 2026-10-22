package com.javanauta.cadastrousuarios.infrastructure.repository;

import com.javanauta.cadastrousuarios.infrastructure.entity.Usuario;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
