package br.com.unisinos.clinica.abc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unisinos.clinica.abc.dao.HorarioIndisponivelDAO;
import br.com.unisinos.clinica.abc.dao.ItemAgendaDAO;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.HorarioIndisponivel;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;

@Service
public class AgendarConsultaService {

	@Autowired private HorarioIndisponivelDAO horarioIndisponivelDAO;
	@Autowired private ItemAgendaDAO itemAgendaDAO;
	
	private static Logger logger = LoggerFactory.getLogger(AnexarExameService.class);
	
	public boolean hasItemAgendaNaData(Date dataInicio, Date dataFim) {
		return itemAgendaDAO.hasItemAgendaNaData(dataInicio, dataFim);
	}
	
	public boolean hasHorarioIndisponivelNaData(Date dataInicio, Date dataFim) {
		return horarioIndisponivelDAO.hasHorarioIndisponivelNaData(dataInicio, dataFim);
	}	
	
	public boolean save(ItemAgenda itemAgenda) throws Exception {
		return itemAgendaDAO.save(itemAgenda);
	}
	
	public boolean validarCamposObrigatorios(ItemAgenda itemAgenda) {
		boolean valido = false;
		valido = ((itemAgenda.getInicio() != null) && (itemAgenda.getFim() != null) && 
				(itemAgenda.getDescricao() != null)  && (itemAgenda.getLocal() != null));
		
		return valido;
	}
		
}
