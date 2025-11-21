package com.lucas.aprendizado_logica.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="nome", nullable= false)
    private String nome;

    @Column(name="estoque", nullable=false)
    private int estoque;

    public Produto() {
    }

    public Produto(Long id, String nome, int estoque) {
        if(estoque < 0){
            throw new IllegalArgumentException("Estoque não pode ser negativo");
        }
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
