package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.service.PacientesService;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PacientesControllerTest extends TestBase {

    @Mock
    PacientesService service;

    @InjectMocks PacientesController controller;

    @Test
    public void listaPaciente() throws Exception {
        //when
        controller.listaPaciente();
        // then
        Mockito.verify(service, Mockito.times(1)).buscaPacientes();
        Mockito.verifyNoMoreInteractions(service);
    }

    @Test
    public void cadastrarPaciente() throws Exception {
        // given
        CadastrarPacienteRequest cadastrarPacienteRequest = Mockito.mock(CadastrarPacienteRequest.class);
        //when
        controller.cadastrarPaciente(cadastrarPacienteRequest);
        // then
        Mockito.verify(service, Mockito.times(1)).cadastrarPaciente(cadastrarPacienteRequest);
        Mockito.verifyNoMoreInteractions(service);
    }

}
