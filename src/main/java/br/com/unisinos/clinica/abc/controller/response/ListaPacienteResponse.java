package br.com.unisinos.clinica.abc.controller.response;

import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;

import java.util.List;

public class ListaPacienteResponse {
    private List<Paciente> pacientes;

    public ListaPacienteResponse(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
