package br.com.unisinos.clinica.abc.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;

public class AgendarConsultaControllerTest {

	AgendarConsultaController controller;
	ItemAgenda itemAgenda;

	@Before
	public void setUp() throws ParseException{
		controller = new AgendarConsultaController();		
	}

	@Test
	public void testAgendarConsulta() {		
		Assert.assertTrue(true);
	}

}
