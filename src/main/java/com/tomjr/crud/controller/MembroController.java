package com.tomjr.crud.controller;

import com.tomjr.crud.service.impl.MembroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/membro")
@Api(value = "API de Portólios", description = "CRUD para Portfólios")
public class MembroController {

    MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @PostMapping(value = "/idProjeto/{idProjeto}/idPessoa/{idPessoa}")
    @ResponseStatus(code = HttpStatus.OK)
    @ApiOperation(value = "Adição de membros a projetos", response = String.class)
    public String adicionaMembroProjeto(@PathVariable(value = "idProjeto") Long idProjeto, @PathVariable(value = "idPessoa") Long idPessoa) {
        return membroService.save(idProjeto, idPessoa);
    }
}
