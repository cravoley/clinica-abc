package br.com.unisinos.clinica.abc.model.usuario.cadastro.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cidade {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private Estado estado;
}
