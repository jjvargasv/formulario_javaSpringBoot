package com.jjvargas.formulario_nuevo.controller;



import com.jjvargas.formulario_nuevo.model.Usuario;
import com.jjvargas.formulario_nuevo.service.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }
    
    @PostMapping("/registrar")
    public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, 
                                 BindingResult result, 
                                 Model model) {
        
        if (result.hasErrors()) {
            return "formulario";
        }
        
        if (usuarioService.obtenerPorEmail(usuario.getEmail()) != null) {
            model.addAttribute("errorEmail", "El email ya está registrado");
            return "formulario";
        }
        
        usuarioService.guardarUsuario(usuario);
        return "redirect:/exito";
    }
    
    @GetMapping("/exito")
    public String mostrarExito() {
        return "exito";
    }
    
    @GetMapping("/lista")
    public String mostrarLista(Model model) {
        model.addAttribute("usuarios", usuarioService.obtenerTodos());
        return "lista";
    }
}