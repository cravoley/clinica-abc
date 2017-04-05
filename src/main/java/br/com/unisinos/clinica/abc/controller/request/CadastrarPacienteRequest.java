package br.com.unisinos.clinica.abc.controller.request;

import br.com.unisinos.clinica.abc.validator.ValidCPF;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CadastrarPacienteRequest {
    @NotNull String nome;
    @NotNull String sobrenome;
    @NotNull LocalDate dataNascimento;
    @NotNull @CPF String cpf;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }
}
