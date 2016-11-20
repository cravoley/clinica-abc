package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.response.AnexarExameResponse;
import br.com.unisinos.clinica.abc.service.AnexarExameService;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import com.google.common.net.MediaType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;


public class AnexarExameControllerTest extends TestBase {

	@Mock
	private AnexarExameService service;

	@InjectMocks
	private AnexarExameController controller;


	@Test
	public void caminhoFeliz() {
		MockMultipartFile mockExam = new MockMultipartFile("exame", "exame.pdf", MediaType.PDF.toString(), "".getBytes());

		// Mock service response
		Mockito.when(service.hasPrimeiraConsulta(Mockito.anyString())).thenReturn(true);
		Mockito.when(service.validarExame(mockExam)).thenReturn(true);
		Mockito.when(service.save("paciente", mockExam)).thenReturn(true);

		AnexarExameResponse response = controller.adicionarExame("paciente", mockExam);

		Assert.assertTrue(response.exame);
		Assert.assertTrue(response.primeiraConsulta);
		Assert.assertTrue(response.salvo);
	}


	@Test
	public void primeiraConsultaNaoRealizada() {
		MockMultipartFile mockExam = new MockMultipartFile("exame", "exame.pdf", MediaType.PDF.toString(), "".getBytes());

		// Mock service response
		Mockito.when(service.hasPrimeiraConsulta(Mockito.anyString())).thenReturn(false);
		Mockito.when(service.validarExame(mockExam)).thenReturn(true);
		Mockito.when(service.save("paciente", mockExam)).thenReturn(true);

		AnexarExameResponse response = controller.adicionarExame("paciente", mockExam);

		Assert.assertFalse(response.primeiraConsulta);
		Assert.assertTrue(response.exame);
		Assert.assertTrue(response.salvo);
	}



	@Test
	public void exameComFormatoInvalido() {
		MockMultipartFile mockExam = new MockMultipartFile("exame", "exame.pdf", MediaType.PDF.toString(), "".getBytes());

		// Mock service response
		Mockito.when(service.hasPrimeiraConsulta(Mockito.anyString())).thenReturn(true);
		Mockito.when(service.validarExame(mockExam)).thenReturn(false);
		Mockito.when(service.save("paciente", mockExam)).thenReturn(true);

		AnexarExameResponse response = controller.adicionarExame("paciente", mockExam);

		Assert.assertFalse(response.exame);
		Assert.assertTrue(response.primeiraConsulta);
		Assert.assertTrue(response.salvo);
	}

}
