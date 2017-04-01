package br.com.unisinos.clinica.abc.service;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;

import java.util.List;

public interface PacientesService {

    Paciente cadastrarPaciente(CadastrarPacienteRequest request);

    List<Paciente> buscaPacientes(Integer page);
}
