package br.com.unisinos.clinica.abc.controller;

import org.junit.Assert;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;

public class AgendarConsultaController {
	public boolean agendar(ItemAgenda itemAgenda) {
		
		try {
			AgendarConsultaService.getInstance().salvar(itemAgenda);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
}
