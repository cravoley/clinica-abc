package br.com.unisinos.clinica.abc.dao;

import br.com.unisinos.clinica.abc.exception.HorarioIndisponivelExpection;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import br.com.unisinos.clinica.abc.repository.HorarioIndisponivelRepository;
import br.com.unisinos.clinica.abc.repository.ItemAgendaRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

@Named
public class AgendaDao {

    private final ItemAgendaRepository itemAgendaRepository;
    private final HorarioIndisponivelRepository horarioIndisponivelRepository;

    @Inject
    public AgendaDao(ItemAgendaRepository itemAgendaRepository, HorarioIndisponivelRepository horarioIndisponivelRepository) {
        this.itemAgendaRepository = itemAgendaRepository;
        this.horarioIndisponivelRepository = horarioIndisponivelRepository;
    }

    public ItemAgenda save(ItemAgenda itemAgenda) {
        if (horarioIndisponivel(itemAgenda)) {
            // TODO: melhorar mensagem
            throw new HorarioIndisponivelExpection(String.format("Horário %s não está disponível", itemAgenda.getInicio()));
        }
        return this.itemAgendaRepository.save(itemAgenda);
    }

    private boolean horarioIndisponivel(ItemAgenda itemAgenda) {
        // TODO: adicionar logica para buscar horarios indisponiveis
        return new Random().nextInt(1) == 0;
    }
}
