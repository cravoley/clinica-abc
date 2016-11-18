package br.com.unisinos.clinica.abc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.HorarioIndisponivel;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;

public class AgendarConsultaService {
	
	private static AgendarConsultaService uniqueInstance;
	private List<ItemAgenda> itensAgendado;
	private List<HorarioIndisponivel> horariosIndisponiveis;

	private AgendarConsultaService() throws ParseException {
		itensAgendado = new ArrayList<>();
		horariosIndisponiveis = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		String dataInicioString = "11/11/2016 08:00:00";
		Date dataInicio = sdf.parse(dataInicioString);
		String dataFimString = "11/11/2016 09:00:00";
		Date dataFim = sdf.parse(dataFimString);
		
		ItemAgenda itemAgenda = new ItemAgenda();
		itemAgenda.setInicio(dataInicio);
		itemAgenda.setFim(dataFim);
		itemAgenda.setDescricao("Consulta João da Silva");
		itemAgenda.setLocal("Clínica Vida");
		
		itensAgendado.add(itemAgenda);
		
		sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		dataInicioString = "11/11/2016 09:00:00";
		dataInicio = sdf.parse(dataInicioString);
		dataFimString = "11/11/2016 10:00:00";
		dataFim = sdf.parse(dataFimString);
		
		itemAgenda = new ItemAgenda();
		itemAgenda.setInicio(dataInicio);
		itemAgenda.setFim(dataFim);
		itemAgenda.setDescricao("Consulta Alberto Carlos");
		itemAgenda.setLocal("Clínica Vida");
		
		itensAgendado.add(itemAgenda);
		
		sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		dataInicioString = "11/11/2016 10:00:00";
		dataInicio = sdf.parse(dataInicioString);
		dataFimString = "11/11/2016 11:00:00";
		dataFim = sdf.parse(dataFimString);
		
		itemAgenda = new ItemAgenda();
		itemAgenda.setInicio(dataInicio);
		itemAgenda.setFim(dataFim);
		itemAgenda.setDescricao("Consulta Maurício Souza");
		itemAgenda.setLocal("Clínica Vida");
		
		itensAgendado.add(itemAgenda);
		
		sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
		dataInicioString = "11/11/2016 11:00:00";
		dataInicio = sdf.parse(dataInicioString);
		dataFimString = "11/11/2016 12:00:00";
		dataFim = sdf.parse(dataFimString);
		
		itemAgenda = new ItemAgenda();
		itemAgenda.setInicio(dataInicio);
		itemAgenda.setFim(dataFim);
		itemAgenda.setDescricao("Consulta Carlos Miguel");
		itemAgenda.setLocal("Clínica Vida");
		
		itensAgendado.add(itemAgenda);
		
		SimpleDateFormat stf = new SimpleDateFormat("hh:mm:ss");
		String horaInicioString = "08:00:00";
		String horaFimString = "12:00:00";
		Date horaInicio = stf.parse(horaInicioString);
		Date horaFim = stf.parse(horaFimString);
		
		HorarioIndisponivel horarioIndisponivel = new HorarioIndisponivel();
		horarioIndisponivel.setDiaSemana(2);
		horarioIndisponivel.setHoraInicio(horaInicio);
		horarioIndisponivel.setHoraFim(horaFim);
		horarioIndisponivel.setMotivo("Convensão");
		
		horariosIndisponiveis.add(horarioIndisponivel);		
	}

	public static synchronized AgendarConsultaService getInstance() throws ParseException {
		if (uniqueInstance == null)
			uniqueInstance = new AgendarConsultaService();

		return uniqueInstance;
	}
	
	
	public ItemAgenda salvar(ItemAgenda itemAgenda) throws Exception {
		
		if (!validarCamposObrigatorios(itemAgenda)) {
			throw new Exception("Campos obrigatórios devem ser preenchidos!");
		}
		
		if (existeConsultaNaData(itemAgenda)) {
			throw new Exception("Já existe uma consulta no horário "+ itemAgenda.getInicio()  +"!");
		}
		
		if (horarioIndisponivel(itemAgenda)) {
			throw new Exception("Horario indisponível "+ itemAgenda.getInicio()  +"!");
		}
		
		return itemAgenda;
	}
	
	private boolean validarCamposObrigatorios(ItemAgenda itemAgenda) {
		boolean valido = false;
		valido = ((itemAgenda.getInicio() != null) && (itemAgenda.getFim() != null) && 
				(itemAgenda.getDescricao() != null)  && (itemAgenda.getLocal() != null));
		
		return valido;
	}
	
	private boolean existeConsultaNaData(ItemAgenda itemAgenda) {
		boolean existe = false;
		for (ItemAgenda itemAgendaBusca : itensAgendado) {
			existe = itemAgendaBusca.getInicio().equals(itemAgenda.getInicio());
			if (existe) {
				break;
			}
		}
		
		return existe;
	}
	
	private boolean horarioIndisponivel(ItemAgenda itemAgenda) {
		boolean indisponivel = false;
		for (HorarioIndisponivel horarioIndisponivel : horariosIndisponiveis) {
			
			GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(itemAgenda.getInicio());
            int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK);
            
            if (diaDaSemana == horarioIndisponivel.getDiaSemana()) {
            	//TODO
            	indisponivel = true;
            	break;
            }
		}
		
		return indisponivel;
	}

	public List<ItemAgenda> getItensAgendado() {
		return itensAgendado;
	}

	public void setItensAgendado(List<ItemAgenda> itensAgendado) {
		this.itensAgendado = itensAgendado;
	}

	public List<HorarioIndisponivel> getHorariosIndisponiveis() {
		return horariosIndisponiveis;
	}

	public void setHorariosIndisponiveis(List<HorarioIndisponivel> horariosIndisponiveis) {
		this.horariosIndisponiveis = horariosIndisponiveis;
	}
}
