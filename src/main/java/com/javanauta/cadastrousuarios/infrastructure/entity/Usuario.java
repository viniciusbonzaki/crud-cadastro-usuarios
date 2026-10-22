package com.javanauta.cadastrousuarios.infrastructure.entity;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuarios")
@Entity
public class Usuario {
    // Identificador Único de cada Usuário (ID)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Campos de cada Usuário
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = true)
    private String email;
}
