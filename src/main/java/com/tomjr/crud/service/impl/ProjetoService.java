package com.tomjr.crud.service.impl;

import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.model.Projeto;
import com.tomjr.crud.repo.IProjetoRepository;
import com.tomjr.crud.service.IProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoService implements IProjetoService {


    @Autowired
    IProjetoRepository projetoRepository;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    MembroService membroService;

    public List<Projeto> getAllProjeto() {
        List<Projeto> projetoList = new ArrayList<>();
        List<Pessoa> listGerentes = pessoaService.getAllGerentes();
        projetoRepository.findAll().stream().map(projeto ->
                {
                    for (Pessoa gerente : listGerentes) {
                        if (gerente.getId().equals(projeto.getIdgerente())) {
                            projeto.setNomeGerente(gerente.getNome());
                        }
                    }
                    projeto.setMembros(membroService.obterMembrosProjeto(projeto.getId()));
                    projetoList.add(projeto);
                    return projeto;
                }

        ).collect(Collectors.toList());

        return projetoList;
    }

    public Optional<Projeto> getProjetoById(Long id) {
        return projetoRepository.findById(id);
    }

    public boolean saveOrUpdateProjeto(Projeto projeto) {
        Projeto updatedProjeto = projetoRepository.save(projeto);
        if (projetoRepository.findById(updatedProjeto.getId()).isPresent()) {
            return true;
        }
        return false;
    }

    @Transactional
    public boolean deleteProjeto(Long id) {
        membroService.deleteMembrosByIdProjeto(id);
        projetoRepository.deleteById(id);
        if (!projetoRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

}
