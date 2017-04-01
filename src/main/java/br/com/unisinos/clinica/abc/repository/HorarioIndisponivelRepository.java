package br.com.unisinos.clinica.abc.repository;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.HorarioIndisponivel;
import org.springframework.data.repository.CrudRepository;

import java.time.DayOfWeek;
import java.util.List;

public interface HorarioIndisponivelRepository extends CrudRepository<HorarioIndisponivel, Long> {

    List<HorarioIndisponivel> findAllByDiaSemanaOrderByHoraInicio(DayOfWeek dia);
}
