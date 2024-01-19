package com.tomjr.crud.service;

import java.util.List;

public interface IMembroService {

    String save(Long idProjeto, Long idPessoa);
    void deleteMembrosByIdPessoa(Long idPessoa);
    void deleteMembrosByIdProjeto(Long idProjeto);
    List<String> obterMembrosProjeto(Long idProjeto);

}
