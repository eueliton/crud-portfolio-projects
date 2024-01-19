package com.tomjr.crud.service;

import com.tomjr.crud.model.Projeto;

import java.util.List;
import java.util.Optional;

public interface IProjetoService {
    List<Projeto> getAllProjeto();

    Optional<Projeto> getProjetoById(Long id);

    boolean saveOrUpdateProjeto(Projeto projeto);

    boolean deleteProjeto(Long id);
}
