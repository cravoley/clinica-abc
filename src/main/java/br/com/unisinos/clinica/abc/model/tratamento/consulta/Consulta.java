package br.com.unisinos.clinica.abc.model.tratamento.consulta;

import br.com.unisinos.clinica.abc.model.tratamento.Convenio;

public class Consulta {
	private double valor;
	private boolean reconsulta;
	private boolean confirmado;
	private boolean realizado;
	private String obervacoes;
	private Antropometria antropometria;
	private Sala sala;
	private Convenio convenio;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isReconsulta() {
		return reconsulta;
	}

	public void setReconsulta(boolean reconsulta) {
		this.reconsulta = reconsulta;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public String getObervacoes() {
		return obervacoes;
	}

	public void setObervacoes(String obervacoes) {
		this.obervacoes = obervacoes;
	}

	public Antropometria getAntropometria() {
		return antropometria;
	}

	public void setAntropometria(Antropometria antropometria) {
		this.antropometria = antropometria;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
}
