package br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda;

import java.util.Date;

public class HorarioIndisponivel {
	private int diaSemana;
	private Date horaInicio;
	private Date horaFim;
	private char recorrente;
	private String motivo;

	public HorarioIndisponivel() {
		recorrente = '0';
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public char getRecorrente() {
		return recorrente;
	}

	public void setRecorrente(char recorrente) {
		this.recorrente = recorrente;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
