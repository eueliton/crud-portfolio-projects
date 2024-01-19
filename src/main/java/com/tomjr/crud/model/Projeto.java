package com.tomjr.crud.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "PROJETO")
public class Projeto {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_inicio;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_previsao_fim;

    @Column
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_fim;

    @Column
    private String descricao;

    @Column
    private String status;

    @Column
    private Double orcamento;

    @Column
    private String risco;

    @Column
    private Long idgerente;

    @Transient
    private String nomeGerente;

    @Transient
    private List<String> membros;

    public List<String> getMembros() {
        return membros;
    }

    public void setMembros(List<String> membros) {
        this.membros = membros;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
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

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_previsao_fim() {
        return data_previsao_fim;
    }

    public void setData_previsao_fim(Date data_previsao_fim) {
        this.data_previsao_fim = data_previsao_fim;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public String getRisco() {
        return risco;
    }

    public void setRisco(String risco) {
        this.risco = risco;
    }

    public Long getIdgerente() {
        return idgerente;
    }

    public void setIdgerente(Long idgerente) {
        this.idgerente = idgerente;
    }


}
