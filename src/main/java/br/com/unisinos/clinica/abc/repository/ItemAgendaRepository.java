package br.com.unisinos.clinica.abc.repository;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda.ItemAgenda;
import org.springframework.data.repository.CrudRepository;

public interface ItemAgendaRepository extends CrudRepository<ItemAgenda, Long> {
}
