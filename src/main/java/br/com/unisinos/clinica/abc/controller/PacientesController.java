package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.controller.response.CadastraPacienteResponse;
import br.com.unisinos.clinica.abc.controller.response.ListaPacienteResponse;
import br.com.unisinos.clinica.abc.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacientesController {

    private PacientesService service;

    @Autowired
    public PacientesController(PacientesService service) {
        this.service = service;
    }

    @RequestMapping(value = "/lista", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ListaPacienteResponse listaPaciente() {
        return service.buscaPacientes();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CadastraPacienteResponse cadastrarPaciente(@Validated @RequestBody CadastrarPacienteRequest request) {
        return service.cadastrarPaciente(request);
    }
}
