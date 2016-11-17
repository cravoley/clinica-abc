package br.com.unisinos.clinica.abc.model.tratamento.exame;

import br.com.unisinos.clinica.abc.model.usuario.impl.Nutricionista;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;

import java.util.Date;
import java.util.List;

public class Exame {
	private Date dataSolicitacao;
	private Date dataRealizacao;
	private String resultado;
	private String localExame;
	private List<AnexoExame> anexoExameList;
	private Paciente paciente;
	private Nutricionista nutricionista;
	private TipoExame tipoExame;
}
