package br.com.unisinos.clinica.abc.model.usuario.cadastro.endereco;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco {
    @Id
    @GeneratedValue
    private Long codigo;
    private TipoEndereco tipoEndereco;
    private String rua;
    private Integer numero;
    private String complemento;
    @OneToOne
    private Bairro bairro;
    private boolean principal;

}
