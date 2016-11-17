package br.com.unisinos.clinica.abc.model.usuario;

public abstract class Usuario extends Pessoa {
	private String senha;
	private String lembreteSenha;
	private boolean ativo;
	private TipoUsuario tipoUsuario;
}
