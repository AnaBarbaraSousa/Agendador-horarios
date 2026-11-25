package com.workspace.agendador_horarios.service;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.workspace.agendador_horarios.repository.AgendamentoRepository;



@Service
@RequiredArgsConstructor 

public class AgendamentoService {
    public Agendamento salvarAgendamento(Agendamento agendamento) {
        
        LocalDateTime horaAgendamento = agendamento.getDataHoraAgendamento();
        LocalDateTime horaFim = agendamento.getDataHoraAgendamento().plusMinutes(1);
        
        Agendamento agendados = AgendamentoRepository.findByServicoDataHoraAgendamentoBetween(agendamento.getServico(), horaAgendamento, horaFim);
        if(Objets.isNull(agendados)){
            throw new RuntimeException("Horário já está preenchido");
        }
            return agendamento;
        } 
       
}


