package com.tomjr.crud.service;

import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.repo.IPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    public static final Integer FUNCIONARIO = 1;
    public static final Integer GERENTE = 2;

    @Autowired
    IPessoaRepository pessoaRepository;

    @Autowired
    MembroService membroService;

    public List<Pessoa> getAllPessoa() {
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaRepository.findAll().forEach(pessoa -> pessoaList.add(pessoa));

        return pessoaList;
    }

    public List<Pessoa> getAllGerentes() {
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaRepository.findAllByGerenteIsTrue().forEach(pessoa -> pessoaList.add(pessoa));

        return pessoaList;
    }

    public Optional<Pessoa> getPessoaById(Long id) {
        return pessoaRepository.findById(id);
    }

    public boolean saveOrUpdatePessoa(Pessoa pessoa) {
        if (pessoa.getCargo().equals(FUNCIONARIO)) {
            pessoa.setFuncionario(true);
            pessoa.setGerente(false);
        }
        if (pessoa.getCargo().equals(GERENTE)) {
            pessoa.setFuncionario(false);
            pessoa.setGerente(true);
        }

        Pessoa updatedPessoa = pessoaRepository.save(pessoa);

        if (pessoaRepository.findById(updatedPessoa.getId()).isPresent()) {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deletePessoa(Long id) {
        membroService.deleteMembrosByIdPessoa(id);
        pessoaRepository.deleteById(id);
        if (!pessoaRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

}
