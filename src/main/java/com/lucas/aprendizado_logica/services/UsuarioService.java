package com.lucas.aprendizado_logica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.aprendizado_logica.models.Usuario;
import com.lucas.aprendizado_logica.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    public UsuarioRepository usuarioRepository;

    public Long contar(){
        return usuarioRepository.count();
    }

    public Usuario buscar(Long id){
        Usuario u = usuarioRepository.findById(id).get();
        return u;
    }

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario login1(Usuario usuario){
        Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
        if(u != null && u.getSenha().equals(usuario.getSenha())){
            return u;
        }
        return null;
    }

    /*
    Atualizar desfuncional */
    @Transactional
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

    @Transactional
    public boolean atualizar(Long id, Usuario usuario){
        Usuario u = usuarioRepository.findById(id).get();
        if (u != null){

            if(usuario.getNome() != null){
                u.setNome(usuario.getNome());
            }

            if(usuario.getEmail() != null){
                u.setEmail(usuario.getEmail());
            }

            if(usuario.getCpf() != null){
                u.setCpf(usuario.getCpf());
            }

            if(usuario.getTelefone() != null){
                u.setTelefone(usuario.getTelefone());
            }
            
            if(usuario.getSenha() != null){
                u.setSenha(usuario.getSenha());
            }
            return true;
        }
        return false;
    }
}
