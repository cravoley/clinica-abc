package br.com.unisinos.clinica.abc.model.usuario.cadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefone {
    @Id
    @GeneratedValue
    private Long codigo;
    private int prefixo;
    private int numero;
    private TipoTelefone tipo;
}
