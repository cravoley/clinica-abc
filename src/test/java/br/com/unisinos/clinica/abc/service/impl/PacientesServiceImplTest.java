package br.com.unisinos.clinica.abc.service.impl;

import br.com.unisinos.clinica.abc.controller.response.ListaPacienteResponse;
import br.com.unisinos.clinica.abc.dao.PacienteDAO;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.sql.ResultSet;

import static org.mockito.Mockito.when;

public class PacientesServiceImplTest extends TestBase {

    @Mock
    PacienteDAO pacienteDAO;
    @InjectMocks PacientesServiceImpl service;

    @Test
    public void buscaPacientes() throws Exception {
        // given
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        when(resultSet.ite)
        when(pacienteDAO.procuraPacientes()).thenReturn(resultSet);
        // when
        ListaPacienteResponse pacientes = service.buscaPacientes();
        // then

    }

    @Test
    public void cadastrarPaciente() throws Exception {

    }

}
