package br.com.unisinos.clinica.abc.model.usuario;

import br.com.unisinos.clinica.abc.model.usuario.cadastro.endereco.Endereco;
import br.com.unisinos.clinica.abc.model.usuario.cadastro.Sexo;
import br.com.unisinos.clinica.abc.model.usuario.cadastro.Telefone;

import java.util.Date;
import java.util.List;

public abstract class Pessoa {
	private long codigo;
	private String nome;
	private Sexo sexo;
	private String email;
	private Date dataNascimento;
	private Date dataCadastro;
	private String rg;
	private String cpf;
	private List<Telefone> telefoneList;
	private List<Endereco> enderecoList;
}
