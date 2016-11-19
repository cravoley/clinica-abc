package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.response.AnexarExameResponse;
import br.com.unisinos.clinica.abc.service.AnexarExameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller("/exame/anexar")
public class AnexarExameController {

	@Autowired
	private AnexarExameService service;


	@ResponseBody
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AnexarExameResponse adicionarExame(@RequestParam("name") final String name,
											  @RequestParam("exame") final MultipartFile exame) {
		AnexarExameResponse response = new AnexarExameResponse();
		if (!service.validarExame(exame)) {
			response.exame = false;
		}

		if (!service.hasPrimeiraConsulta(name)) {
			response.primeiraConsulta = false;
		}

		response.salvo = service.save(name, exame);

		return response;
	}


}
