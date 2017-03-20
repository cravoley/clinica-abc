package br.com.unisinos.clinica.abc.dao;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class PacienteDAO {
    public boolean hasPrimeiraConsulta(String nomePaciente) {
        return false;
    }

    public ResultSet procuraPacientes() {
        return null;
    }
}
