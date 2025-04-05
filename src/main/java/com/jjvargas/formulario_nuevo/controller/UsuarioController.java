package com.jjvargas.formulario_nuevo.controller;

import com.jjvargas.formulario_nuevo.model.Usuario;
import com.jjvargas.formulario_nuevo.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String contraseña) {
        return usuarioService.login(email, contraseña);
    }
}