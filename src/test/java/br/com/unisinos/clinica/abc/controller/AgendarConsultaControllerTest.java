package br.com.unisinos.clinica.abc.controller;


import br.com.unisinos.clinica.abc.controller.request.AgendarRequest;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;

import static org.mockito.Matchers.any;

public class AgendarConsultaControllerTest {

    AgendarConsultaController controller;
    AgendarConsultaService service;
    ItemAgenda itemAgenda;

    @Before
    public void setUp() throws ParseException {
        service = Mockito.mock(AgendarConsultaService.class);
        controller = new AgendarConsultaController(service);
    }

    @Test
    public void testAgendarConsulta() {

        controller.agendar(new AgendarRequest());

        Mockito.verify(service, Mockito.times(1)).adicionarEvento(any(AgendarRequest.class));
        Mockito.verifyNoMoreInteractions(service);
    }

}
