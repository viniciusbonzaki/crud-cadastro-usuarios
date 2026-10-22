package com.javanauta.cadastrousuarios.infrastructure.repository;

import com.javanauta.cadastrousuarios.infrastructure.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
