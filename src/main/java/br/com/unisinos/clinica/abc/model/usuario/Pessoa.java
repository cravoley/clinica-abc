package br.com.unisinos.clinica.abc.model.usuario;

import br.com.unisinos.clinica.abc.model.usuario.cadastro.Sexo;
import br.com.unisinos.clinica.abc.model.usuario.cadastro.Telefone;
import br.com.unisinos.clinica.abc.model.usuario.cadastro.endereco.Endereco;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class Pessoa {
    @Id
    @GeneratedValue
    private Long codigo;
    private String nome;
    private Sexo sexo;
    private String email;
    private LocalDate dataNascimento;
    private LocalDate dataCadastro;
    private String rg;
    private String cpf;
    @OneToMany
    private List<Telefone> telefoneList;
    @OneToMany
    private List<Endereco> enderecoList;
    private String sobrenome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Telefone> getTelefoneList() {
        return telefoneList;
    }

    public void addTelefone(Telefone telefone) {
        if (this.telefoneList == null) {
            this.telefoneList = new ArrayList<>();
        }
        this.telefoneList.add(telefone);
    }

    public void setTelefoneList(List<Telefone> telefoneList) {
        this.telefoneList = telefoneList;
    }

    public List<Endereco> getEnderecoList() {
        return enderecoList;
    }

    public void addEndereco(Endereco endereco) {
        if (this.enderecoList == null) {
            this.enderecoList = new ArrayList<>();
        }
        this.enderecoList.add(endereco);
    }

    public void setEnderecoList(List<Endereco> enderecoList) {
        this.enderecoList = enderecoList;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
