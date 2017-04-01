package br.com.unisinos.clinica.abc.service;

import br.com.unisinos.clinica.abc.controller.request.AgendarRequest;
import br.com.unisinos.clinica.abc.dao.AgendaDao;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.HorarioIndisponivel;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;

import javax.inject.Inject;
import javax.inject.Named;
import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Named
public class AgendarConsultaService {


    private AgendaDao dao;

    @Inject
    public AgendarConsultaService(AgendaDao dao) {
        this.dao = dao;
    }

    private static AgendarConsultaService uniqueInstance;
    private List<ItemAgenda> itensAgendado;
    private List<HorarioIndisponivel> horariosIndisponiveis;

    private AgendarConsultaService() throws ParseException {
        itensAgendado = new ArrayList<>();
        horariosIndisponiveis = new ArrayList<>();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/M/yyyy hh:mm:ss");
        String dataInicioString = "11/11/2016 08:00:00";
        LocalDateTime dataInicio = LocalDateTime.parse(dataInicioString);
        String dataFimString = "11/11/2016 09:00:00";
        LocalDateTime dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        ItemAgenda itemAgenda = new ItemAgenda();
        itemAgenda.setInicio(dataInicio);
        itemAgenda.setFim(dataFim);
        itemAgenda.setDescricao("Consulta João da Silva");
        itemAgenda.setLocal("Clínica Vida");

        itensAgendado.add(itemAgenda);

        dataInicioString = "11/11/2016 09:00:00";
        dataInicio = LocalDateTime.parse(dataInicioString, dateTimeFormatter);
        dataFimString = "11/11/2016 10:00:00";
        dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        itemAgenda = new ItemAgenda();
        itemAgenda.setInicio(dataInicio);
        itemAgenda.setFim(dataFim);
        itemAgenda.setDescricao("Consulta Alberto Carlos");
        itemAgenda.setLocal("Clínica Vida");

        itensAgendado.add(itemAgenda);

        dataInicioString = "11/11/2016 10:00:00";
        dataInicio = LocalDateTime.parse(dataInicioString, dateTimeFormatter);
        dataFimString = "11/11/2016 11:00:00";
        dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        itemAgenda = new ItemAgenda();
        itemAgenda.setInicio(dataInicio);
        itemAgenda.setFim(dataFim);
        itemAgenda.setDescricao("Consulta Maurício Souza");
        itemAgenda.setLocal("Clínica Vida");

        itensAgendado.add(itemAgenda);

        dataInicioString = "11/11/2016 11:00:00";
        dataInicio = LocalDateTime.parse(dataInicioString, dateTimeFormatter);
        dataFimString = "11/11/2016 12:00:00";
        dataFim = LocalDateTime.parse(dataFimString, dateTimeFormatter);

        itemAgenda = new ItemAgenda();
        itemAgenda.setInicio(dataInicio);
        itemAgenda.setFim(dataFim);
        itemAgenda.setDescricao("Consulta Carlos Miguel");
        itemAgenda.setLocal("Clínica Vida");

        itensAgendado.add(itemAgenda);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        String horaInicioString = "08:00:00";
        String horaFimString = "12:00:00";
        LocalTime horaInicio = LocalTime.parse(horaInicioString, timeFormatter);
        LocalTime horaFim = LocalTime.parse(horaFimString, timeFormatter);

        HorarioIndisponivel horarioIndisponivel = new HorarioIndisponivel();
        horarioIndisponivel.setDiaSemana(DayOfWeek.THURSDAY);
        horarioIndisponivel.setHoraInicio(horaInicio);
        horarioIndisponivel.setHoraFim(horaFim);
        horarioIndisponivel.setMotivo("Convensão");

        horariosIndisponiveis.add(horarioIndisponivel);
    }

    // TODO: remover
    public ItemAgenda salvar(ItemAgenda itemAgenda) throws Exception {

        if (!validarCamposObrigatorios(itemAgenda)) {
            throw new Exception("Campos obrigatórios devem ser preenchidos!");
        }

        if (existeConsultaNaData(itemAgenda)) {
            throw new Exception("Já existe uma consulta no horário " + itemAgenda.getInicio() + "!");
        }

        if (horarioIndisponivel(itemAgenda)) {
            throw new Exception("Horario indisponível " + itemAgenda.getInicio() + "!");
        }

        return itemAgenda;
    }

    private boolean validarCamposObrigatorios(ItemAgenda itemAgenda) {
        boolean valido = false;
        valido = ((itemAgenda.getInicio() != null) && (itemAgenda.getFim() != null) &&
                (itemAgenda.getDescricao() != null) && (itemAgenda.getLocal() != null));

        return valido;
    }
    // TODO: remover
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

    // TODO: remover
    private boolean horarioIndisponivel(ItemAgenda itemAgenda) {
        boolean indisponivel = false;
        for (HorarioIndisponivel horarioIndisponivel : horariosIndisponiveis) {
            DayOfWeek diaDaSemana = DayOfWeek.from(itemAgenda.getInicio());
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

    public ItemAgenda adicionarEvento(AgendarRequest request) {
        ItemAgenda itemAgenda = ItemAgenda.fromRequest(request);
        return this.dao.save(itemAgenda);
    }
}
