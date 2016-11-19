package br.com.unisinos.clinica.abc.service;

import br.com.unisinos.clinica.abc.dao.ExamesDAO;
import br.com.unisinos.clinica.abc.dao.PacienteDAO;
import com.google.common.net.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class AnexarExameService {

	@Autowired private ExamesDAO examesDAO;
	@Autowired private PacienteDAO pacientesDAO;

	private static Logger logger = LoggerFactory.getLogger(AnexarExameService.class);

	public boolean validarExame(MultipartFile exame) {
		MediaType mediaType = MediaType.parse(exame.getContentType());
		return mediaType.is(MediaType.PDF) ||
				mediaType.is(MediaType.ANY_IMAGE_TYPE);
	}

	public boolean hasPrimeiraConsulta(String paciente) {
		return pacientesDAO.hasPrimeiraConsulta(paciente);
	}

	public boolean save(String name, MultipartFile exam) {
		FileWriter fw = null;
		try {
			File tempFile = File.createTempFile("exam", exam.getOriginalFilename());
			fw = new FileWriter(tempFile);
			fw.write(new String(exam.getBytes()));
			fw.close();
			return examesDAO.save(name, tempFile.getAbsolutePath());
		} catch (IOException e) {
			logger.warn("Unable to save exam", e);
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e1) {
					logger.error("Unable to close file", e1);
				}
			}
		}
		return false;
	}
}
