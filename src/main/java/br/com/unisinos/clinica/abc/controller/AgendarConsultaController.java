package br.com.unisinos.clinica.abc.controller;


import br.com.unisinos.clinica.abc.controller.request.AgendarRequest;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
@RequestMapping("/consulta")
public class AgendarConsultaController {

    private final AgendarConsultaService service;

    @Inject
    AgendarConsultaController(AgendarConsultaService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ItemAgenda agendar(@Valid @RequestBody AgendarRequest request) {
        return service.adicionarEvento(request);
    }
}
