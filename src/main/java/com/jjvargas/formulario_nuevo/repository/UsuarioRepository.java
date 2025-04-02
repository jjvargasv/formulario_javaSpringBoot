package com.jjvargas.formulario_nuevo.repository;

// Asegúrate de que el paquete sea correcto

import com.jjvargas.formulario_nuevo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Método personalizado para buscar por email
    Usuario findByEmail(String email);
}