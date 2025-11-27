package com.lucas.aprendizado_logica.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.aprendizado_logica.models.Agendamento;
import com.lucas.aprendizado_logica.repositories.AgendamentoRepository;

import jakarta.transaction.Transactional;

@Service
public class AgendamentoService {

    @Autowired
    public AgendamentoRepository agendamentoRepository;

    @Transactional
    public Agendamento criar(Agendamento agendamento) {
        LocalDateTime ini = agendamento.getInicioConsulta();
        LocalDateTime fim = agendamento.getFimConsulta();
        LocalDateTime agora = LocalDateTime.now();
        //long medicoId = 3; utilizar agendamento.getMedicoId();

        List<Agendamento> lista = agendamentoRepository.findAll();

        if (!ini.isBefore(agora) && agendamento.getTratamentos().length < 10) {
            for (Agendamento a : lista) {
                boolean sobrepor = a.getInicioConsulta().isBefore(fim) && a.getFimConsulta().isAfter(ini);

                if (sobrepor) {
                    return null;
                }
            }
            return agendamentoRepository.save(agendamento);
        }
        return null;
    }

}
