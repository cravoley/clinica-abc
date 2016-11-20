package br.com.unisinos.clinica.abc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.unisinos.clinica.abc.controller.response.AnexarExameResponse;
import br.com.unisinos.clinica.abc.controller.response.AgendarConsultaResponse;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;

@Controller("/consulta")
public class AgendarConsultaController {

	@Autowired
	private AgendarConsultaService service;


	@ResponseBody
	@RequestMapping(value="/agendar",method = RequestMethod.POST)
	public AgendarConsultaResponse agendarConsulta(@RequestParam("itemAgenda") final ItemAgenda itemAgenda) throws Exception {
		AgendarConsultaResponse response = new AgendarConsultaResponse();
		if (!service.validarCamposObrigatorios(itemAgenda)) {
			response.itemAgenda = false;
		}

		if (service.hasHorarioIndisponivelNaData(itemAgenda.getInicio(), itemAgenda.getFim())) {
			response.horarioIndisponivel = true;
		}
		
		if (service.hasItemAgendaNaData(itemAgenda.getInicio(), itemAgenda.getFim())) {
			response.itemAgendadoNaData = true;
		}

		response.salvo = service.save(itemAgenda);

		return response;
	}


}