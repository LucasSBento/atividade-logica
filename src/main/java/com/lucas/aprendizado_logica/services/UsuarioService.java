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

    public Usuario login1(Usuario usuario){
        Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
        if(u != null && u.getSenha().equals(usuario.getSenha())){
            return u;
        }
        return null;
    }

    public boolean atualizar1(Long id, String nome, String email, String cpf, String telefone, String senha){
        Usuario u = usuarioRepository.findById(id).get();
        if(u != null){
            u.setNome(nome);
            u.setEmail(email);
            u.setCpf(cpf);
            u.setTelefone(telefone);
            u.setSenha(senha);
            return true;
        }
        return false;
    }

    public boolean atualizar(Long id, Usuario usuario){
        
    }
}
