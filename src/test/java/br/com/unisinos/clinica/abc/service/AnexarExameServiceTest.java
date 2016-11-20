package br.com.unisinos.clinica.abc.service;

import br.com.unisinos.clinica.abc.dao.ExamesDAO;
import br.com.unisinos.clinica.abc.dao.PacienteDAO;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import com.google.common.net.MediaType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;

public class AnexarExameServiceTest extends TestBase {

	@Mock private ExamesDAO examesDAO;
	@Mock private PacienteDAO pacientesDAO;

	@InjectMocks private AnexarExameService service;

	@Test
	public void validarExame() throws Exception {
		MockMultipartFile pdfExam = new MockMultipartFile("exame", "exame.pdf", MediaType.PDF.toString(), "".getBytes());
		MockMultipartFile pngExam = new MockMultipartFile("exame", "exame.png", MediaType.PNG.toString(), "".getBytes());
		MockMultipartFile jpgExam = new MockMultipartFile("exame", "exame.png", MediaType.JPEG.toString(), "".getBytes());
		MockMultipartFile bmpExam = new MockMultipartFile("exame", "exame.png", MediaType.BMP.toString(), "".getBytes());
		MockMultipartFile gifExam = new MockMultipartFile("exame", "exame.png", MediaType.GIF.toString(), "".getBytes());
		Assert.assertTrue(service.validarExame(pdfExam));
		Assert.assertTrue(service.validarExame(pngExam));
		Assert.assertTrue(service.validarExame(jpgExam));
		Assert.assertTrue(service.validarExame(bmpExam));
		Assert.assertTrue(service.validarExame(gifExam));
		// invalid
		MockMultipartFile invalid1 = new MockMultipartFile("exame", "exame.png", MediaType.APPLE_MOBILE_CONFIG.toString(), "".getBytes());
		MockMultipartFile invalid2 = new MockMultipartFile("exame", "exame.png", MediaType.EOT.toString(), "".getBytes());
		MockMultipartFile invalid3 = new MockMultipartFile("exame", "exame.png", MediaType.ANY_TEXT_TYPE.toString(), "".getBytes());
		Assert.assertFalse(service.validarExame(invalid1));
		Assert.assertFalse(service.validarExame(invalid2));
		Assert.assertFalse(service.validarExame(invalid3));
	}

	@Test
	public void hasPrimeiraConsulta() throws Exception {
		Mockito.when(pacientesDAO.hasPrimeiraConsulta(Mockito.anyString())).thenReturn(true, false);

		Assert.assertTrue(service.hasPrimeiraConsulta("paciente"));
		Assert.assertFalse(service.hasPrimeiraConsulta("paciente2"));
	}

	@Test
	public void save() throws Exception {
		Mockito.when(examesDAO.save(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

		MockMultipartFile pdfExam = new MockMultipartFile("exame", "exame.pdf", MediaType.PDF.toString(), "".getBytes());
		Assert.assertTrue(service.save("paciente", pdfExam));
	}

}
