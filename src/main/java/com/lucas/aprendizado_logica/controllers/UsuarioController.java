package com.lucas.aprendizado_logica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.aprendizado_logica.models.Usuario;
import com.lucas.aprendizado_logica.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping
    public Long contar(){
        return usuarioService.contar();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario, @RequestParam String confSenha){
        if(usuario.getSenha().equals(confSenha)){
            return usuarioService.cadastrar(usuario);
        }
        return null;
    }

    @PostMapping
    public Usuario login(@RequestParam String email, @RequestParam String senha){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuarioService.login1(usuario);
    }
    
}
