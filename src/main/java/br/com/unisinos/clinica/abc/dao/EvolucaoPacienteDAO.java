package br.com.unisinos.clinica.abc.dao;

import br.com.unisinos.clinica.abc.model.tratamento.consulta.Antropometria;
import org.springframework.stereotype.Component;

@Component
public class EvolucaoPacienteDAO {
	public boolean save(String paciente, Antropometria antropometria) {
		// save
		return true;
	}
}
