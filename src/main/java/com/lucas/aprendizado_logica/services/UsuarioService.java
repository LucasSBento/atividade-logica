package com.lucas.aprendizado_logica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.aprendizado_logica.models.Usuario;
import com.lucas.aprendizado_logica.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    public Long contar(){
        return usuarioRepository.count();
    }

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario login(Usuario usuario){
        Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
        if(u != null && u.getSenha().equals(usuario.getSenha())){
            return u;
        }
        return null;
    }
}
