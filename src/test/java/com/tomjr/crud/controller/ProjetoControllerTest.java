package com.tomjr.crud.controller;

import com.tomjr.crud.model.Projeto;
import com.tomjr.crud.service.impl.PessoaService;
import com.tomjr.crud.service.impl.ProjetoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProjetoControllerTest {

    static String ENDPOINT = "/projeto";

    private InputStream is;

    private MockMvc mvc;

    @InjectMocks
    private ProjetoController controller;

    @Mock
    private ProjetoService service;

    @Mock
    private PessoaService pessoaService;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Retorna a lista de projetos")
    public void listProjetosTest() throws Exception {

        String url = ENDPOINT + "/list";

        BDDMockito.given(service.getAllProjeto()).willReturn(new ArrayList<>());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Sucesso ao salvar registro de projeto")
    public void saveProjetoSuccessTest() throws Exception {

        String url = ENDPOINT + "/save";

        BDDMockito.given(service.saveOrUpdateProjeto(any())).willReturn(true);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }

    @Test
    @DisplayName("Erro ao salvar registro de  projeto")
    public void saveProjetoErrorTest() throws Exception {

        String url = ENDPOINT + "/save";

        BDDMockito.given(service.saveOrUpdateProjeto(any())).willReturn(false);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Sucesso ao editar registro de projeto")
    public void editProjetoSucessTest() throws Exception {

        String url = ENDPOINT + "/edit/1";

        BDDMockito.given(service.getProjetoById(anyLong())).willReturn(Optional.of(new Projeto()));
        BDDMockito.given(pessoaService.getAllGerentes()).willReturn(new ArrayList<>());
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }


    @Test
    @DisplayName("Erro ao editar registro de projeto")
    public void editProjetoErrorTest() throws Exception {

        String url = ENDPOINT + "/edit/1";

        BDDMockito.given(service.getProjetoById(anyLong())).willReturn(Optional.empty());
        BDDMockito.given(pessoaService.getAllGerentes()).willReturn(new ArrayList<>());
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Sucesso ao editar e salvar registro de  projeto")
    public void editSaveProjetoSucessTest() throws Exception {

        String url = ENDPOINT + "/editSave";

        BDDMockito.given(service.saveOrUpdateProjeto(any())).willReturn(true);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Erro ao editar e salvar registro de projeto")
    public void editSaveProjetoErrorTest() throws Exception {

        String url = ENDPOINT + "/editSave";

        BDDMockito.given(service.saveOrUpdateProjeto(any())).willReturn(false);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Sucesso ao deletar registro de projeto")
    public void deletProjetoSucessTest() throws Exception {

        String url = ENDPOINT + "/delete/1";

        BDDMockito.given(service.deleteProjeto(any())).willReturn(true);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Erro ao deletar registro de projeto")
    public void deleteProjetoErrorTest() throws Exception {

        String url = ENDPOINT + "/delete/1";

        BDDMockito.given(service.deleteProjeto(any())).willReturn(false);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


}
