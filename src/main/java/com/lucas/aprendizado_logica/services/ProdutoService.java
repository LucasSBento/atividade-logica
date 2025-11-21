package com.lucas.aprendizado_logica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    
}
