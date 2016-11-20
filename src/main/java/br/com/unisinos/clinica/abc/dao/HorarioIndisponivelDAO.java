package br.com.unisinos.clinica.abc.dao;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.HorarioIndisponivel;

@Component
public class HorarioIndisponivelDAO {

	public boolean save(HorarioIndisponivel horarioIndisponivel) {
		return false;
	}
	
	public boolean hasHorarioIndisponivelNaData(Date dataInicio, Date dataFim) {
		return false;
	}
}
