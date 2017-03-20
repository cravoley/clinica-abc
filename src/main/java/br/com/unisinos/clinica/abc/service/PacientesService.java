package br.com.unisinos.clinica.abc.service;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.controller.response.CadastraPacienteResponse;
import br.com.unisinos.clinica.abc.controller.response.ListaPacienteResponse;

public interface PacientesService {

    ListaPacienteResponse buscaPacientes();

    CadastraPacienteResponse cadastrarPaciente(CadastrarPacienteRequest request);
}
