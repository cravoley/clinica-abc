package br.com.unisinos.clinica.abc.service.impl;

import br.com.unisinos.clinica.abc.dao.PacienteDAO;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.util.List;

import static org.mockito.Mockito.when;

public class PacientesServiceImplTest extends TestBase {

    @Mock
    PacienteDAO pacienteDAO;
    @InjectMocks PacientesServiceImpl service;

    @Test
    public void cadastrarPaciente() throws Exception {
                  // TODO
    }

}
