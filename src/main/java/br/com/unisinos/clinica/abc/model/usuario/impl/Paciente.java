package br.com.unisinos.clinica.abc.model.usuario.impl;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.model.usuario.Usuario;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Paciente extends Usuario {

    private boolean primeiraConsulta;

    public boolean hadPrimeiraConsulta() {
        return primeiraConsulta;
    }

    public void hadPrimeiraConsulta(boolean primeiraConsulta) {
        this.primeiraConsulta = primeiraConsulta;
    }

    public static Paciente fromRequest(CadastrarPacienteRequest request) {
        Paciente paciente = new Paciente();
        paciente.setCpf(request.getCpf());
        paciente.setNome(request.getNome());
        paciente.setSobrenome(request.getSobrenome());
        paciente.setDataNascimento(request.getDataNascimento());
        return paciente;
    }
}
