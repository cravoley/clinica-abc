package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;
import br.com.unisinos.clinica.abc.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacientesController {

    private PacientesService service;

    @Autowired
    public PacientesController(PacientesService service) {
        this.service = service;
    }

    @RequestMapping(value = {"","/lista"}, method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Paciente> listaPaciente() {
        return listaPaciente(0);
    }

    @RequestMapping(value = "/lista/{page}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Paciente> listaPaciente(@PathParam("page") Integer page) {
        return service.buscaPacientes(page);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Paciente cadastrarPaciente(@Validated @RequestBody CadastrarPacienteRequest request) {
        return service.cadastrarPaciente(request);
    }
}
