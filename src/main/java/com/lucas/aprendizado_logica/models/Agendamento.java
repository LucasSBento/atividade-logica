package com.lucas.aprendizado_logica.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agendamento")
public class Agendamento {


    /*
    Garantir não haver conflito de horário para o mesmo médico.
    Garantir que não aja agendandamento em horário passado.
    Um médico não pode ter 2 agendamentos no mesmo horário
    Garantir max 10 tratamentos por agendamento.
    */
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status", nullable = false)
    private boolean status;

    @Column(name = "delete", nullable = false)
    private boolean delete;
    
    @Column(name = "observacoes", nullable = false)
    private String observacoes;

    @Column(name = "inicio_consulta")
    private LocalDateTime inicioConsulta;

    @Column(name = "fim_consulta")
    private LocalDateTime fimConsulta;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
    
    @Column(name = "data_atualizacao", nullable = false)
    private LocalDateTime dataAtualizacao;

    public Agendamento() {
    }

    public Agendamento(Long id, boolean status, boolean delete, String observacoes, LocalDateTime inicioConsulta,
            LocalDateTime fimConsulta, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.status = true;
        this.status = status;
        this.delete = false;
        this.delete = delete;
        this.observacoes = observacoes;
        this.inicioConsulta = inicioConsulta;
        this.fimConsulta = fimConsulta;
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public LocalDateTime getInicioConsulta() {
        return inicioConsulta;
    }

    public void setInicioConsulta(LocalDateTime inicioConsulta) {
        this.inicioConsulta = inicioConsulta;
    }

    public LocalDateTime getFimConsulta() {
        return fimConsulta;
    }

    public void setFimConsulta(LocalDateTime fimConsulta) {
        this.fimConsulta = fimConsulta;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}