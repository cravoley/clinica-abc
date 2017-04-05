package br.com.unisinos.clinica.abc.model.usuario.impl;

import br.com.unisinos.clinica.abc.model.usuario.Usuario;

import java.time.LocalDate;

public class Nutricionista extends Usuario {
    private String crn;
    private LocalDate dataAdmissao;
    private String especializacao;

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) {
        this.crn = crn;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }
}
