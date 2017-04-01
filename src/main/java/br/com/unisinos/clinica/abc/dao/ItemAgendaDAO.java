package br.com.unisinos.clinica.abc.dao;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;

@Component
public class ItemAgendaDAO {

	public boolean save(ItemAgenda itemAgenda) {
		return false;
	}
	
	public boolean hasItemAgendaNaData(Date dataInicio, Date dataFim) {
		return false;
	}
}