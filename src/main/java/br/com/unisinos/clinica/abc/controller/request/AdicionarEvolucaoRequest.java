package br.com.unisinos.clinica.abc.controller.request;

public class AdicionarEvolucaoRequest {

	private String paciente;
	private double peso;
	private double altura;

	public String getPaciente() {
		return paciente != null ? paciente : "";
	}

	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
