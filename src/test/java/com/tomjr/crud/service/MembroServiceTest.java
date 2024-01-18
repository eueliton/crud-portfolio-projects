package com.tomjr.crud.service;

import com.tomjr.crud.model.Membros;
import com.tomjr.crud.model.MembrosKey;
import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.model.Projeto;
import com.tomjr.crud.repo.IMembroRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MembroServiceTest {


    @Mock
    private PessoaService pessoaService;
    @Mock
    private ProjetoService projetoService;
    @Mock
    private IMembroRepository membroRepository;
    @InjectMocks
    private MembroService membroService;



    @Test
    @DisplayName("Membro Já Vinculado ao Projeto")
    public void saveMembroJaVinculadoTest() {
        Optional<Pessoa> pessoa = Optional.of(new Pessoa());
        Optional<Projeto> projeto = Optional.of(new Projeto());
        Optional<Membros> membro = Optional.of(new Membros(1l, 2l));
        when(pessoaService.getPessoaById(anyLong())).thenReturn(pessoa);
        when(projetoService.getProjetoById(anyLong())).thenReturn(projeto);
        when(membroRepository.findById(any(MembrosKey.class))).thenReturn(membro);
        when(membroRepository.save(any())).thenReturn(membro);
        String msg = membroService.save(1l, 2l);
        assertEquals(msg, "Membro já vinculado ao projeto");

    }

    @Test
    @DisplayName("Pessoa nao existente")
    public void savePessoaNaoExistenteTest() {
        Optional<Pessoa> pessoa = Optional.of(new Pessoa());
        Optional<Projeto> projeto = Optional.of(new Projeto());
        Optional<Membros> membro = Optional.of(new Membros(1l, 2l));
        when(pessoaService.getPessoaById(anyLong())).thenReturn(Optional.empty());
        when(projetoService.getProjetoById(anyLong())).thenReturn(projeto);
        when(membroRepository.findById(any(MembrosKey.class))).thenReturn(Optional.empty());
        when(membroRepository.save(any())).thenReturn(membro);
        String msg = membroService.save(1l, 2l);
        assertEquals(msg, "Pessoa não existente");
    }

    @Test
    @DisplayName("Projeto nao existente")
    public void saveProjetoNaoExistenteTest() {
        Optional<Pessoa> pessoa = Optional.of(new Pessoa());
        Optional<Projeto> projeto = Optional.of(new Projeto());
        Optional<Membros> membro = Optional.of(new Membros(1l, 2l));
        when(pessoaService.getPessoaById(anyLong())).thenReturn(pessoa);
        when(projetoService.getProjetoById(anyLong())).thenReturn(Optional.empty());
        when(membroRepository.findById(any(MembrosKey.class))).thenReturn(Optional.empty());
        when(membroRepository.save(any())).thenReturn(membro);
        String msg = membroService.save(1l, 2l);
        assertEquals(msg, "Projeto não existente");
    }


    @Test
    @DisplayName("Apenas funcionários pode ser adicionados como membros")
    public void saveApenasFuncionariosTest() {
        Pessoa pessoa = new Pessoa();
        pessoa.setGerente(true);
        Optional<Pessoa> pessoaOpt = Optional.of(pessoa);
        Optional<Projeto> projeto = Optional.of(new Projeto());
        Optional<Membros> membro = Optional.of(new Membros(1l, 2l));
        when(pessoaService.getPessoaById(anyLong())).thenReturn(pessoaOpt);
        when(projetoService.getProjetoById(anyLong())).thenReturn(projeto);
        when(membroRepository.findById(any(MembrosKey.class))).thenReturn(Optional.empty());
        when(membroRepository.save(any())).thenReturn(membro);
        String msg = membroService.save(1l, 2l);
        assertEquals(msg, "Apenas funcionários pode ser adicionados como membros");
    }


    @Test
    @DisplayName("Obter membros projeto")
    public void obterMembrosProjetoTest() {
        List<Membros> membrosList = new ArrayList<>();
        membrosList.add(new Membros(1l, 2l));
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1l);
        pessoa.setNome("Nome Sobrenome");
        when(membroRepository.findAllByIdprojetoIs(anyLong())).thenReturn(membrosList);
        when(pessoaService.getPessoaById(anyLong())).thenReturn(Optional.of(pessoa));
        List<String> list = membroService.obterMembrosProjeto(1l);
        assertEquals(list.size(), 1);
    }


}
