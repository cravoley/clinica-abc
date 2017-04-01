package br.com.unisinos.clinica.abc.dao;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.exception.ContentNotFoundException;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;
import br.com.unisinos.clinica.abc.repository.PacienteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PacienteDAO {

    private static final int RECORDS_PER_PAGE = 20;
    private PacienteRepository repository;

    @Inject
    public PacienteDAO(PacienteRepository repository) {
        this.repository = repository;
    }

    public boolean hasPrimeiraConsulta(String nomePaciente) {
        Paciente paciente = this.getPacienteByName(nomePaciente);
        return paciente != null && paciente.hadPrimeiraConsulta();
    }

    private Paciente getPacienteByName(String nomePaciente) {
        return this.repository.findOneByName(nomePaciente);
    }

    public Paciente cadastrarPaciente(CadastrarPacienteRequest request) {
        Paciente paciente = Paciente.fromRequest(request);
        return repository.save(paciente);
    }

    public List<Paciente> listPacientes(Integer page) {
        Page<Paciente> pacientePage = this.repository.findAll(new PageRequest(page, RECORDS_PER_PAGE));
        if (pacientePage.hasContent()) {
            return pacientePage.getContent();
        }
        throw new ContentNotFoundException(String.format("Unable to get pacientes for page %s", page));
    }
}
