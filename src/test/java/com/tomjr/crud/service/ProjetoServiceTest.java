
package com.tomjr.crud.service;

import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.model.Projeto;
import com.tomjr.crud.repo.IProjetoRepository;
import com.tomjr.crud.service.impl.MembroService;
import com.tomjr.crud.service.impl.PessoaService;
import com.tomjr.crud.service.impl.ProjetoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
public class ProjetoServiceTest {


    @Mock
    private IProjetoRepository projetoRepository;
    @Mock
    private MembroService membroService;

    @Mock
    private PessoaService pessoaService;
    @InjectMocks
    private ProjetoService projetoService;

    @Test
    @DisplayName("Get All Projeto Test")
    public void getAllProjetoTest() {
        List<Pessoa> pessoaList = new ArrayList<>();
        Pessoa gerente = new Pessoa();
        gerente.setId(1l);
        gerente.setNome("Nome Gerente");
        pessoaList.add(gerente);
        List<Projeto> projetoList = new ArrayList<>();
        Projeto projeto = new Projeto();
        projeto.setIdgerente(1l);
        projetoList.add(projeto);

        when(pessoaService.getAllGerentes()).thenReturn(pessoaList);
        when(projetoRepository.findAll()).thenReturn(projetoList);
        when(membroService.obterMembrosProjeto(anyLong())).thenReturn(new ArrayList<>());
        List<Projeto> projetoLista = projetoService.getAllProjeto();
        assertEquals(projetoLista.size(), 1);
    }

    @Test
    @DisplayName("Get Projeto By id Test")
    public void getProjetoByIdTest() {
        when(projetoRepository.findById(anyLong())).thenReturn(Optional.of(new Projeto()));
        Optional<Projeto> projeto = projetoService.getProjetoById(1l);
        assertEquals(projeto.isPresent(), true);
    }


    @Test
    @DisplayName("Save or Update Projeto Sucess")
    public void saveOrUpdateProjetoSucessTest() {
        when(projetoRepository.save(any())).thenReturn(new Projeto());
        when(projetoRepository.findById(any())).thenReturn(Optional.of(new Projeto()));
        boolean result = projetoService.saveOrUpdateProjeto(new Projeto());
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Save or Update Projeto Error")
    public void saveOrUpdateProjetoErrorTest() {
        when(projetoRepository.save(any())).thenReturn(new Projeto());
        when(projetoRepository.findById(any())).thenReturn(Optional.empty());
        boolean result = projetoService.saveOrUpdateProjeto(new Projeto());
        assertEquals(result, false);
    }

    @Test
    @DisplayName("Delete Projeto Success")
    public void deleteProjetoSuccessTest() {
        doNothing().when(membroService).deleteMembrosByIdProjeto(any());
        doNothing().when(projetoRepository).deleteById(any());
        when(projetoRepository.findById(any())).thenReturn(Optional.empty());
        boolean result = projetoService.deleteProjeto(1l);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("Delete Projeto Error")
    public void deleteProjetoErrorTest() {
        when(projetoRepository.save(any())).thenReturn(new Pessoa());
        when(projetoRepository.findById(any())).thenReturn(Optional.of(new Projeto()));
        boolean result = projetoService.deleteProjeto(1l);
        assertEquals(result, false);
    }


}
