package com.tomjr.crud.controller;

import com.tomjr.crud.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/membro")
public class MembroController {


    @Autowired
    MembroService membroService;


    @PostMapping(value = "/{idProjeto}/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    public String adicionaMembroProjeto(@PathVariable(value = "idProjeto") Long idProjeto, @PathVariable(value = "idPessoa") Long idPessoa) {
        return membroService.save(idProjeto, idPessoa);

    }
}
