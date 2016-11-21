package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.request.AdicionarEvolucaoRequest;
import br.com.unisinos.clinica.abc.security.SecurityService;
import br.com.unisinos.clinica.abc.service.EvolucaoPacienteService;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class EvolucaoPacienteControllerTest extends TestBase {

	@Mock private SecurityService securityService;
	@Mock private EvolucaoPacienteService service;

	@InjectMocks private EvolucaoPacienteController controller;


	@Test
	public void usuarioAutenticado() {
		Mockito.when(securityService.isAuthenticated()).thenReturn(false, true);
		String expectedMessage = "para acessar é necessário estar logado com perfil nutricionista";
		Assert.assertEquals(expectedMessage, controller.index());
		Assert.assertNotEquals(expectedMessage, controller.index());
	}

	@Test
	public void campoUsuarioComCaracteresInvalidos() {
		String expectedMessage = "o campo usuário não pode conter números e/ou caracteres especiais";
		AdicionarEvolucaoRequest adicionarEvolucaoRequest = new AdicionarEvolucaoRequest();
		adicionarEvolucaoRequest.setPaciente("$awdawdawd");
		Assert.assertEquals(expectedMessage, controller.adicionarEvolucao(adicionarEvolucaoRequest));


		adicionarEvolucaoRequest = new AdicionarEvolucaoRequest();
		adicionarEvolucaoRequest.setPaciente("ddd$aw^dawd:awd");
		Assert.assertEquals(expectedMessage, controller.adicionarEvolucao(adicionarEvolucaoRequest));


		adicionarEvolucaoRequest = new AdicionarEvolucaoRequest();
		adicionarEvolucaoRequest.setPaciente("dddawdawdawd");
		Assert.assertNotEquals(expectedMessage, controller.adicionarEvolucao(adicionarEvolucaoRequest));
	}


	@Test
	public void salvaEvolucao() {

		Mockito.when(service.save(Mockito.any())).thenReturn(true);

		AdicionarEvolucaoRequest adicionarEvolucaoRequest = new AdicionarEvolucaoRequest();
		Assert.assertEquals("evolução salva com sucesso", controller.adicionarEvolucao(adicionarEvolucaoRequest));
	}

	@Test
	public void calcularIMC() {
		AdicionarEvolucaoRequest adicionarEvolucaoRequest = new AdicionarEvolucaoRequest();
		adicionarEvolucaoRequest.setAltura(1.70);
		adicionarEvolucaoRequest.setPeso(70);

		Assert.assertEquals("24,22", controller.calcularIMC(adicionarEvolucaoRequest));
	}
}
