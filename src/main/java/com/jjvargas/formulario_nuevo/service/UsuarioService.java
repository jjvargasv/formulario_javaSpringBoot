package com.jjvargas.formulario_nuevo.service;

import com.jjvargas.formulario_nuevo.model.Usuario;
import com.jjvargas.formulario_nuevo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Indica que esta clase es un servicio de Spring
public class UsuarioService {
    
    @Autowired  // Inyecta automáticamente el repositorio
    private UsuarioRepository usuarioRepository;
    
    // Método para obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();  // Usa el método del repositorio
    }
    
    // Método para guardar un usuario
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);  // Inserta o actualiza en la DB
    }
    
    // Método para buscar un usuario por email
    public Usuario obtenerPorEmail(String email) {
        return usuarioRepository.findByEmail(email);  // Usa el método personalizado
    }
}