package com.tomjr.crud.service;

import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.repo.IPessoaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PessoaServiceTest {


    @Mock
    private IPessoaRepository pessoaRepository;
    @Mock
    private MembroService membroService;
    @InjectMocks
    private PessoaService pessoaService;

    @Test
    @DisplayName("Get All Pessoa Test")
    public void getAllPessoaTest() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa());
        when(pessoaRepository.findAll()).thenReturn(pessoas);
        List<Pessoa> pessoaList = pessoaService.getAllPessoa();
        assertEquals(pessoaList.size(), 1);
    }


    @Test
    @DisplayName("Get All Gerentes Test")
    public void getAllGerentesTest() {
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa());
        when(pessoaRepository.findAllByGerenteIsTrue()).thenReturn(pessoas);
        List<Pessoa> pessoaList = pessoaService.getAllGerentes();
        assertEquals(pessoaList.size(), 1);
    }


    @Test
    @DisplayName("Get Pessoa By id Test")
    public void getPessoaByIdTest() {
        when(pessoaRepository.findById(anyLong())).thenReturn(Optional.of(new Pessoa()));
        Optional<Pessoa> pessoa = pessoaService.getPessoaById(1l);
        assertEquals(pessoa.isPresent(), true);
    }


    @Test
    @DisplayName("Save or Update Pessoa Sucess")
    public void saveOrUpdatePessoaSucessTest() {
        when(pessoaRepository.save(any())).thenReturn(new Pessoa());
        when(pessoaRepository.findById(any())).thenReturn(Optional.of(new Pessoa()));
        boolean result = pessoaService.saveOrUpdatePessoa(new Pessoa());
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Save or Update Pessoa Error")
    public void saveOrUpdatePessoaErrorTest() {
        when(pessoaRepository.save(any())).thenReturn(new Pessoa());
        when(pessoaRepository.findById(any())).thenReturn(Optional.empty());
        boolean result = pessoaService.saveOrUpdatePessoa(new Pessoa());
        assertEquals(result, false);
    }

    @Test
    @DisplayName("Delete Pessoa Success")
    public void deletePessoaSuccessTest() {
        doNothing().when(membroService).deleteMembrosByIdProjeto(any());
        doNothing().when(pessoaRepository).deleteById(any());
        when(pessoaRepository.findById(any())).thenReturn(Optional.empty());
        boolean result = pessoaService.deletePessoa(1l);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Delete Pessoa Error")
    public void deletePessoaErrorTest() {
        when(pessoaRepository.save(any())).thenReturn(new Pessoa());
        when(pessoaRepository.findById(any())).thenReturn(Optional.of(new Pessoa()));
        boolean result = pessoaService.deletePessoa(1l);
        assertEquals(result, false);
    }




}
