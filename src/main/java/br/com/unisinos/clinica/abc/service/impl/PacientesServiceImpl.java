package br.com.unisinos.clinica.abc.service.impl;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.controller.response.CadastraPacienteResponse;
import br.com.unisinos.clinica.abc.controller.response.ListaPacienteResponse;
import br.com.unisinos.clinica.abc.dao.PacienteDAO;
import br.com.unisinos.clinica.abc.service.PacientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacientesServiceImpl implements PacientesService {

    private PacienteDAO pacienteDAO;

    @Autowired
    public PacientesServiceImpl(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    @Override
    public ListaPacienteResponse buscaPacientes() {
        return null;
    }

    @Override
    public CadastraPacienteResponse cadastrarPaciente(CadastrarPacienteRequest request) {
        return null;
    }
}
