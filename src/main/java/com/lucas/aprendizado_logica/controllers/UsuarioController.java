package com.lucas.aprendizado_logica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/contar")
    public Long contar(){
        return usuarioService.contar();
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscar(@PathVariable Long id){
        return usuarioService.buscar(id);
    }

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario, @RequestParam String confSenha){
        if(usuario.getSenha().equals(confSenha)){
            return usuarioService.cadastrar(usuario);
        }
        return null;
    }

    @PostMapping("/login")
    public Usuario login(@RequestParam String email, @RequestParam String senha){
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        return usuarioService.login1(usuario);
    }

    @PutMapping("/atualizar/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.atualizar(id, usuario);
        return usuario;
    }
    
}
