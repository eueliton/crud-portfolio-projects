package com.tomjr.crud.service;

import com.tomjr.crud.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface IPessoaService {

    List<Pessoa> getAllPessoa();

    List<Pessoa> getAllGerentes();

    Optional<Pessoa> getPessoaById(Long id);

    boolean saveOrUpdatePessoa(Pessoa pessoa);

    boolean deletePessoa(Long id);
}
