package br.com.unisinos.clinica.abc.model;

import br.com.unisinos.clinica.abc.model.cadastro.Sexo;
import br.com.unisinos.clinica.abc.model.cadastro.Telefone;

import java.util.Date;
import java.util.List;

public class Pessoa {
	private long codigo;
	private String nome;
	private Sexo sexo;
	private String email;
	private Date dataNascimento;
	private Date dataCadastro;
	private List<Telefone> telefoneList;

}
