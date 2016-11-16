package br.com.unisinos.clinica.abc.controller;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AgendarConsultaControllerTest {

	AgendarConsultaController controller;

	@Before
	public void setUp(){
		controller = new AgendarConsultaController();
	}

	@Test
	public void testAgendarConsulta() {
		boolean agendar = controller.agendar();
		Assert.assertTrue(agendar);
	}

}
