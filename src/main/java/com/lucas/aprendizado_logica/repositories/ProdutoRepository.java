package com.lucas.aprendizado_logica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucas.aprendizado_logica.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
}
