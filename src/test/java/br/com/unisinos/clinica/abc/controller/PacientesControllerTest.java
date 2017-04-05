package br.com.unisinos.clinica.abc.controller;

import br.com.unisinos.clinica.abc.controller.request.CadastrarPacienteRequest;
import br.com.unisinos.clinica.abc.service.PacientesService;
import br.com.unisinos.clinica.abc.test.util.TestBase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class PacientesControllerTest extends TestBase {

    @Mock
    PacientesService service;

    @InjectMocks PacientesController controller;

    @Test
    public void listaPaciente() throws Exception {
        //when
        controller.listaPaciente();
        // then
        verify(service, times(1)).buscaPacientes(anyInt());
        verifyNoMoreInteractions(service);
    }

    @Test
    public void cadastrarPaciente() throws Exception {
        // given
        CadastrarPacienteRequest cadastrarPacienteRequest = mock(CadastrarPacienteRequest.class);
        //when
        controller.cadastrarPaciente(cadastrarPacienteRequest);
        // then
        verify(service, times(1)).cadastrarPaciente(cadastrarPacienteRequest);
        verifyNoMoreInteractions(service);
    }

}
