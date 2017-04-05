package br.com.unisinos.clinica.abc.service.impl;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.dao.PacienteDAO;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;
import br.com.unisinos.clinica.abc.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacientesServiceImpl implements PacientesService {

    private PacienteDAO pacienteDAO;

    @Autowired
    public PacientesServiceImpl(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    @Override
    public List<Paciente> buscaPacientes(Integer page) {
        return this.pacienteDAO.listPacientes(page);
    }

    @Override
    public Paciente cadastrarPaciente(CadastrarPacienteRequest request) {
        return pacienteDAO.cadastrarPaciente(request);
    }
}
