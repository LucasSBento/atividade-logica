package com.lucas.aprendizado_logica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.aprendizado_logica.models.Produto;
import com.lucas.aprendizado_logica.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    public ProdutoService produtoService;

    @GetMapping("/listar")
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return produtoService.cadastrar(produto);
    }

}
