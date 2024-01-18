package com.tomjr.crud.model;

import java.io.Serializable;

public class MembrosKey implements Serializable {

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

    private Long idprojeto;
    private Long idpessoa;

}
