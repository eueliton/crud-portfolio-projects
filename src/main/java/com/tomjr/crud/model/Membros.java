package com.tomjr.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="MEMBROS")
@IdClass( MembrosKey.class)
public class Membros implements Serializable {

    @Id
    private Long id;
    @Column
    private Long idprojeto;
    @Column
    private Long idpessoa;

    public Membros() {
    }

    public Membros(Long idprojeto, Long idpessoa) {
        this.idprojeto = idprojeto;
        this.idpessoa = idpessoa;
    }

    public Long getIdProjeto() {
        return idprojeto;
    }

    public void setIdProjeto(Long idprojeto) {
        this.idprojeto = idprojeto;
    }

    public Long getIdPessoa() {
        return idpessoa;
    }

    public void setIdPessoa(Long idpessoa) {
        this.idpessoa = idpessoa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
