package com.jjvargas.formulario_nuevo.service;

import com.jjvargas.formulario_nuevo.model.Usuario;
import com.jjvargas.formulario_nuevo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        Optional<Usuario> existente = usuarioRepository.findByEmail(usuario.getEmail());
        if (existente.isPresent()) {
            throw new RuntimeException("El usuario ya está registrado.");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String contraseña) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        if (!usuario.getContraseña().equals(contraseña)) {
            throw new RuntimeException("Credenciales inválidas.");
        }
        return usuario;
    }
}