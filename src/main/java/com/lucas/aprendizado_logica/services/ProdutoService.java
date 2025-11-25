package com.lucas.aprendizado_logica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucas.aprendizado_logica.models.Produto;
import com.lucas.aprendizado_logica.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    public ProdutoRepository produtoRepository;

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto cadastrar(Produto produto){
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto atualizarEstoque(Long id, int quantidade){
        Produto p = produtoRepository.findById(id).get();
        if(quantidade > 0){
            p.setEstoque(quantidade);
            return p;
        }
        return null;
    }
    
    @Transactional
    public Produto removerEstoque(Long id, int quantidade){
        Produto p = produtoRepository.findById(id).get();
        if(quantidade <= p.getEstoque()){
            p.setEstoque(p.getEstoque() - quantidade);
            return p;
        }
        return null;
    }
}
