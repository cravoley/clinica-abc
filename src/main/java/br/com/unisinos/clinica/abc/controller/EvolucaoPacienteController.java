package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.request.AdicionarEvolucaoRequest;
import br.com.unisinos.clinica.abc.security.SecurityService;
import br.com.unisinos.clinica.abc.service.EvolucaoPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

@Controller("/evolucao")
public class EvolucaoPacienteController {

	@Autowired private SecurityService security;
	@Autowired private EvolucaoPacienteService service;

	@RequestMapping(path = "/",
			method = RequestMethod.GET,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String index() {
		if (!security.isAuthenticated()) {
			return "para acessar é necessário estar logado com perfil nutricionista";
		}
		return "";
	}

	@RequestMapping(path = "/",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String adicionarEvolucao(@RequestBody AdicionarEvolucaoRequest request) {
		if (!request.getPaciente().matches("[a-zA-Z]*")) {
			return "o campo usuário não pode conter números e/ou caracteres especiais";
		}

		// TODO: add data validation
		if (service.save(request)) {
			return "evolução salva com sucesso";
		} else {
			return "Ocorreu um erro ao salvar os dados do usuário";
		}
	}

	@RequestMapping(path = "/calcularimc",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public String calcularIMC(AdicionarEvolucaoRequest adicionarEvolucaoRequest) {

		double imc = adicionarEvolucaoRequest.getPeso() / (adicionarEvolucaoRequest.getAltura() * adicionarEvolucaoRequest.getAltura());
		DecimalFormat decimalFormat = new DecimalFormat("00.00", DecimalFormatSymbols.getInstance(Locale.forLanguageTag("PT-BR")));
		return String.valueOf(decimalFormat.format(imc));
	}
}
