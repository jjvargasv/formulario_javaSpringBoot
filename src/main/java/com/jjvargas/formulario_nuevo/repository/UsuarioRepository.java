package com.jjvargas.formulario_nuevo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjvargas.formulario_nuevo.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}