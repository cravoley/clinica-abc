package br.com.unisinos.clinica.abc.model.tratamento.consulta.agenda;

import br.com.unisinos.clinica.abc.controller.request.AgendarRequest;
import br.com.unisinos.clinica.abc.model.usuario.impl.Paciente;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class ItemAgenda {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String descricao;
    private String local;
    private LocalDateTime dataCadastro;
    private boolean ativo;
    @OneToOne
    private Paciente usuario;

    public ItemAgenda() {
        dataCadastro = LocalDateTime.now();
        ativo = true;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Paciente getUsuario() {
        return usuario;
    }

    public void setUsuario(Paciente usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static ItemAgenda fromRequest(AgendarRequest request) {
        ItemAgenda itemAgenda = new ItemAgenda();
        itemAgenda.setInicio(request.getHorarioConsulta());
        itemAgenda.setDescricao(request.getDescricao());
        return itemAgenda;
    }
}
