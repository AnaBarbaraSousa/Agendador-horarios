package com.workspace.agendador_horarios.repository;

import com.workspace.agendador_horarios.infrastructury.entity.agendamento;
import com.workspace.agendador_horarios.service.Agendamento;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<agendamento, Long> {

    Agendamento findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataHorainicio, LocalDateTime dataHoraFim);

}
