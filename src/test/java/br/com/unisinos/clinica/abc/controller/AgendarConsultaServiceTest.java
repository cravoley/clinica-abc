package br.com.unisinos.clinica.abc.controller;


import br.com.unisinos.clinica.abc.dao.AgendaDao;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.service.AgendarConsultaService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AgendarConsultaServiceTest {

    AgendarConsultaService service;
    ItemAgenda itemAgenda11, itemAgenda12, itemAgenda14;

    @Before
    public void setUp() throws ParseException {
        AgendaDao agendaDao = Mockito.mock(AgendaDao.class);
        service = new AgendarConsultaService(agendaDao);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", new Locale("pt","BR"));
        String dataInicioString = "11/11/2016 11:00:00";
        LocalDateTime dataInicio = LocalDateTime.parse(dataInicioString, dateTimeFormatter);
        String dataFimString = "11/11/2016 12:00:00";
        LocalDateTime dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        itemAgenda11 = new ItemAgenda();
        itemAgenda11.setInicio(dataInicio);
        itemAgenda11.setFim(dataFim);
        itemAgenda11.setDescricao("Consulta João da Silva");
        itemAgenda11.setLocal("Clínica Vida");

        dataInicioString = "12/11/2016 11:00:00";
        dataInicio = LocalDateTime.parse(dataInicioString, dateTimeFormatter);
        dataFimString = "12/11/2016 12:00:00";
        dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        itemAgenda12 = new ItemAgenda();
        itemAgenda12.setInicio(dataInicio);
        itemAgenda12.setFim(dataFim);
        itemAgenda12.setDescricao("Consulta Mário Roberto");
        itemAgenda12.setLocal("Clínica Vida");

        dataInicioString = "14/11/2016 11:00:00";
        dataInicio = LocalDateTime.parse(dataInicioString, dateTimeFormatter);
        dataFimString = "14/11/2016 12:00:00";
        dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        itemAgenda14 = new ItemAgenda();
        itemAgenda14.setInicio(dataInicio);
        itemAgenda14.setFim(dataFim);
        itemAgenda14.setDescricao("Consulta Alberto Raul");
        itemAgenda14.setLocal("Clínica Vida");
    }

    @Test
    public void testAgendarConsulta() {
        ItemAgenda agendado = null;
        try {
            agendado = service.salvar(itemAgenda12);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(agendado, itemAgenda12);
    }
}
