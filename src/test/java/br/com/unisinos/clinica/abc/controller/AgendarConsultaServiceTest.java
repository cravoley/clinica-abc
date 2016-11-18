package br.com.unisinos.clinica.abc.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;

public class AgendarConsultaServiceTest {

	AgendarConsultaService service;
	ItemAgenda itemAgenda11, itemAgenda12, itemAgenda14;

	@Before
	public void setUp() throws ParseException{
		service = AgendarConsultaService.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		String dataInicioString = "11/11/2016 11:00:00";
		Date dataInicio = sdf.parse(dataInicioString);
		String dataFimString = "11/11/2016 12:00:00";
		Date dataFim = sdf.parse(dataFimString);
		
		itemAgenda11 = new ItemAgenda();
		itemAgenda11.setInicio(dataInicio);
		itemAgenda11.setFim(dataFim);
		itemAgenda11.setDescricao("Consulta João da Silva");
		itemAgenda11.setLocal("Clínica Vida");		
		
		sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		dataInicioString = "12/11/2016 11:00:00";
		dataInicio = sdf.parse(dataInicioString);
		dataFimString = "12/11/2016 12:00:00";
		dataFim = sdf.parse(dataFimString);
		
		itemAgenda12 = new ItemAgenda();
		itemAgenda12.setInicio(dataInicio);
		itemAgenda12.setFim(dataFim);
		itemAgenda12.setDescricao("Consulta Mário Roberto");
		itemAgenda12.setLocal("Clínica Vida");
		
		sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		dataInicioString = "14/11/2016 11:00:00";
		dataInicio = sdf.parse(dataInicioString);
		dataFimString = "14/11/2016 12:00:00";
		dataFim = sdf.parse(dataFimString);
		
		itemAgenda14 = new ItemAgenda();
		itemAgenda14.setInicio(dataInicio);
		itemAgenda14.setFim(dataFim);
		itemAgenda14.setDescricao("Consulta Alberto Raul");
		itemAgenda14.setLocal("Clínica Vida");
	}

	@Test
	public void testAgendarConsulta() {		
		ItemAgenda agendado = null;
		try {
			agendado = service.salvar(itemAgenda12);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		Assert.assertEquals(agendado, itemAgenda12);
	}
	
	@Test(expected=Exception.class)
	public void testAgendarConsultaExistente() throws Exception {			
		service.salvar(itemAgenda11);
				
		Assert.fail("Não ocorreu nenhuma exceção!");
	}

	@Test(expected=Exception.class)
	public void testAgendarConsultaIndisponivel() throws Exception {			
		service.salvar(itemAgenda14);
				
		Assert.fail("Não ocorreu nenhuma exceção!");
	}
}
