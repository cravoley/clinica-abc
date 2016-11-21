package br.com.unisinos.clinica.abc.service;

import br.com.unisinos.clinica.abc.controller.request.AdicionarEvolucaoRequest;
import br.com.unisinos.clinica.abc.dao.EvolucaoPacienteDAO;
import br.com.unisinos.clinica.abc.model.tratamento.consulta.Antropometria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvolucaoPacienteService {

	@Autowired private EvolucaoPacienteDAO evolucaoPacienteDAO;

	public boolean save(AdicionarEvolucaoRequest request) {
		Antropometria antropometria = new Antropometria();
		antropometria.setPeso(request.getPeso());
		antropometria.setAltura(request.getAltura());
		return this.evolucaoPacienteDAO.save(request.getPaciente(), antropometria);
	}
}
