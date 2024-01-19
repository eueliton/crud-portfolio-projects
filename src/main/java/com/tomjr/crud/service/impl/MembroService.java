package com.tomjr.crud.service.impl;

import com.tomjr.crud.model.Membros;
import com.tomjr.crud.model.MembrosKey;
import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.model.Projeto;
import com.tomjr.crud.repo.IMembroRepository;
import com.tomjr.crud.service.IMembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MembroService implements IMembroService {


    @Autowired
    IMembroRepository membroRepository;

    @Autowired
    PessoaService pessoaService;

    @Autowired
    ProjetoService projetoService;

    public String save(Long idProjeto, Long idPessoa) {
        StringBuilder msgError = new StringBuilder();

        Optional<Pessoa> pessoa = pessoaService.getPessoaById(idPessoa);
        if (!pessoa.isPresent()) {
            msgError.append("Pessoa não existente");
        }

        if (pessoa.isPresent()) {
            if (pessoa.get().getGerente()) {
                msgError.append("Apenas funcionários pode ser adicionados como membros");
            }
        }


        Optional<Projeto> projeto = projetoService.getProjetoById(idProjeto);
        if (!projeto.isPresent()) {
            msgError.append("Projeto não existente");
        }
        MembrosKey membrosKey = new MembrosKey();
        membrosKey.setIdPessoa(idPessoa);
        membrosKey.setIdProjeto(idProjeto);
        Optional<Membros> membro = membroRepository.findById(membrosKey);
        if (membro.isPresent()) {
            msgError.append("Membro já vinculado ao projeto");
        }

        if (msgError.toString().equals("")) {
            Membros membros = new Membros();
            membros.setIdPessoa(idPessoa);
            membros.setIdProjeto(idProjeto);
            membroRepository.save(membros);
            return "Membro cadastrado com sucesso";
        }

        return msgError.toString();

    }
    public void deleteMembrosByIdPessoa(Long idPessoa) {
        membroRepository.deleteByIdpessoaIs(idPessoa);
    }
    public void deleteMembrosByIdProjeto(Long idProjeto) {
        membroRepository.deleteByIdprojetoIs(idProjeto);
    }
    public List<String> obterMembrosProjeto(Long idProjeto) {

        List<String> nomeMembros = new ArrayList<>();

        List<Membros> membrosList = membroRepository.findAllByIdprojetoIs(idProjeto);

        membrosList.stream().map(f -> {
                    Optional<Pessoa> pessoa = pessoaService.getPessoaById(f.getIdPessoa());
                    if (pessoa.isPresent()) {
                        nomeMembros.add(pessoa.get().getNome());
                    }
                    return f;
                }

        ).collect(Collectors.toList());

        return nomeMembros;

    }
}
