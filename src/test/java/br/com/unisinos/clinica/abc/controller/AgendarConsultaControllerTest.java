package br.com.unisinos.clinica.abc.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.unisinos.clinica.abc.controller.response.AgendarConsultaResponse;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;
import br.com.unisinos.clinica.abc.test.util.TestBase;


public class AgendarConsultaControllerTest extends TestBase {

	@Mock
	private AgendarConsultaService service;

	@InjectMocks
	private AgendarConsultaController controller;


	@Test
	public void caminhoFeliz() throws Exception {
		ItemAgenda itemAgenda = new ItemAgenda();
		Date data = new Date();
		itemAgenda.setInicio(data);
		itemAgenda.setFim(data);

		// Mock service response
		Mockito.when(service.hasHorarioIndisponivelNaData(data, data)).thenReturn(false);
		Mockito.when(service.hasItemAgendaNaData(data, data)).thenReturn(false);
		Mockito.when(service.validarCamposObrigatorios(itemAgenda)).thenReturn(true);
		Mockito.when(service.save(itemAgenda)).thenReturn(true);

		AgendarConsultaResponse response = controller.agendarConsulta(itemAgenda);

		Assert.assertFalse(response.horarioIndisponivel);
		Assert.assertFalse(response.itemAgendadoNaData);
		Assert.assertTrue(response.itemAgenda);
		Assert.assertTrue(response.salvo);
	}
	
	@Test
	public void horarioIndisponivel() throws Exception {
		ItemAgenda itemAgenda = new ItemAgenda();
		Date data = new Date();
		itemAgenda.setInicio(data);
		itemAgenda.setFim(data);

		// Mock service response
		Mockito.when(service.hasHorarioIndisponivelNaData(data, data)).thenReturn(true);
		Mockito.when(service.hasItemAgendaNaData(data, data)).thenReturn(false);
		Mockito.when(service.validarCamposObrigatorios(itemAgenda)).thenReturn(true);
		Mockito.when(service.save(itemAgenda)).thenReturn(true);

		AgendarConsultaResponse response = controller.agendarConsulta(itemAgenda);

		Assert.assertTrue(response.horarioIndisponivel);
		Assert.assertFalse(response.itemAgendadoNaData);
		Assert.assertTrue(response.itemAgenda);
		Assert.assertTrue(response.salvo);
	}

	@Test
	public void itemAgendaNaData() throws Exception {
		ItemAgenda itemAgenda = new ItemAgenda();
		Date data = new Date();
		itemAgenda.setInicio(data);
		itemAgenda.setFim(data);

		// Mock service response
		Mockito.when(service.hasHorarioIndisponivelNaData(data, data)).thenReturn(false);
		Mockito.when(service.hasItemAgendaNaData(data, data)).thenReturn(true);
		Mockito.when(service.validarCamposObrigatorios(itemAgenda)).thenReturn(true);
		Mockito.when(service.save(itemAgenda)).thenReturn(true);

		AgendarConsultaResponse response = controller.agendarConsulta(itemAgenda);

		Assert.assertFalse(response.horarioIndisponivel);
		Assert.assertTrue(response.itemAgendadoNaData);
		Assert.assertTrue(response.itemAgenda);
		Assert.assertTrue(response.salvo);
	}

	@Test
	public void camposObrigatoriosNaoPreenchidos() throws Exception {
		ItemAgenda itemAgenda = new ItemAgenda();
		Date data = new Date();
		itemAgenda.setInicio(data);
		itemAgenda.setFim(data);

		// Mock service response
		Mockito.when(service.hasHorarioIndisponivelNaData(data, data)).thenReturn(false);
		Mockito.when(service.hasItemAgendaNaData(data, data)).thenReturn(false);
		Mockito.when(service.validarCamposObrigatorios(itemAgenda)).thenReturn(false);
		Mockito.when(service.save(itemAgenda)).thenReturn(true);

		AgendarConsultaResponse response = controller.agendarConsulta(itemAgenda);

		Assert.assertFalse(response.horarioIndisponivel);
		Assert.assertFalse(response.itemAgendadoNaData);
		Assert.assertFalse(response.itemAgenda);
		Assert.assertTrue(response.salvo);
	}
}
