package com.tomjr.crud.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ProjetoDTO implements Serializable {

    private Long id;
    private String nome;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_inicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_previsao_fim;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data_fim;
    private String descricao;
    private String status;
    private Double orcamento;
    private String risco;
    private Long idgerente;
    private String nomeGerente;
    private List<String> membros;

    public ProjetoDTO() {
    }

    public ProjetoDTO(Long id, String nome, Date data_inicio, Date data_previsao_fim, Date data_fim, String descricao, String status, Double orcamento, String risco, Long idgerente, String nomeGerente, List<String> membros) {
        this.id = id;
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.data_previsao_fim = data_previsao_fim;
        this.data_fim = data_fim;
        this.descricao = descricao;
        this.status = status;
        this.orcamento = orcamento;
        this.risco = risco;
        this.idgerente = idgerente;
        this.nomeGerente = nomeGerente;
        this.membros = membros;
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

    public String getNomeGerente() {
        return nomeGerente;
    }

    public void setNomeGerente(String nomeGerente) {
        this.nomeGerente = nomeGerente;
    }

    public List<String> getMembros() {
        return membros;
    }

    public void setMembros(List<String> membros) {
        this.membros = membros;
    }
}
