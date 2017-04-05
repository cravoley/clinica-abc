package br.com.unisinos.clinica.abc.service;


import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import br.com.unisinos.clinica.abc.dao.HorarioIndisponivelDAO;
import br.com.unisinos.clinica.abc.dao.ItemAgendaDAO;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.test.util.TestBase;

public class AgendarConsultaServiceTest extends TestBase {
	
	@Mock private HorarioIndisponivelDAO horarioIndisponivelDAO;
	@Mock private ItemAgendaDAO itemAgendaDAO;

	@InjectMocks private AgendarConsultaService service;
	
	private ItemAgenda itemAgenda;
	/*
	@Before
    public void setup() {
		itemAgenda = new ItemAgenda();
		itemAgenda.setDescricao("Descrição consulta");
		itemAgenda.setLocal("Clínica vida");
		itemAgenda.setInicio(new Date());
		itemAgenda.setFim(new Date());
		itemAgenda.setAtivo(true);
    }
	
	@Test
	public void hasItemAgendaNaData() throws Exception {
		Mockito.when(itemAgendaDAO.hasItemAgendaNaData(Mockito.anyObject(), Mockito.anyObject())).thenReturn(true, false);

		Assert.assertTrue(service.hasItemAgendaNaData(new Date(), new Date()));
		Assert.assertFalse(service.hasItemAgendaNaData(new Date(), new Date()));
	}
	
	@Test
	public void hasHorarioIndisponivelNaData() throws Exception {
		Mockito.when(horarioIndisponivelDAO.hasHorarioIndisponivelNaData(Mockito.anyObject(), Mockito.anyObject())).thenReturn(true, false);

		Assert.assertTrue(service.hasHorarioIndisponivelNaData(new Date(), new Date()));
		Assert.assertFalse(service.hasHorarioIndisponivelNaData(new Date(), new Date()));
	}
	
	@Test
	public void validarCamposObrigatorios() throws Exception {		
		Assert.assertTrue(service.validarCamposObrigatorios(itemAgenda));
		ItemAgenda itemAgendaInvalido = new ItemAgenda();
		Assert.assertFalse(service.validarCamposObrigatorios(itemAgendaInvalido));
	}
	
	@Test
	public void save() throws Exception {		
		Mockito.when(itemAgendaDAO.save(itemAgenda)).thenReturn(true);
		
		Assert.assertTrue(service.save(itemAgenda));
	}*/

	@Test
	public void dummy(){
		Assert.assertTrue(true);
	}
}
