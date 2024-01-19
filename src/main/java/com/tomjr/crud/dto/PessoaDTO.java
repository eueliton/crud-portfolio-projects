package com.tomjr.crud.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class PessoaDTO implements Serializable {

    private Long id;

    private String nome;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date datanascimento;

    private String cpf;

    private Boolean funcionario;

    private Boolean gerente;

    private Integer cargo;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, Date datanascimento, String cpf, Boolean funcionario, Boolean gerente, Integer cargo) {
        this.id = id;
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.cpf = cpf;
        this.funcionario = funcionario;
        this.gerente = gerente;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getGerente() {
        return gerente;
    }

    public void setGerente(Boolean gerente) {
        this.gerente = gerente;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }
}
