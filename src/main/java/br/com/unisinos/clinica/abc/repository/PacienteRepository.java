package br.com.unisinos.clinica.abc.repository;

import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long> {
    Paciente findOneByNome(String nomePaciente);
}
