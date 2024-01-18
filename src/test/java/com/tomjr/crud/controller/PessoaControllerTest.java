package com.tomjr.crud.controller;

import com.tomjr.crud.model.Pessoa;
import com.tomjr.crud.service.PessoaService;
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
public class PessoaControllerTest {

    static String ENDPOINT = "/pessoa";

    private InputStream is;

    private MockMvc mvc;

    @InjectMocks
    private PessoaController controller;

    @Mock
    private PessoaService service;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Retorna a lista de pessoas")
    public void listPessoaTest() throws Exception {

        String url = ENDPOINT + "/list";

        BDDMockito.given(service.getAllPessoa()).willReturn(new ArrayList<>());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Sucesso ao salvar registro de pessoas")
    public void savePessoaSuccessTest() throws Exception {

        String url = ENDPOINT + "/save";

        BDDMockito.given(service.saveOrUpdatePessoa(any())).willReturn(true);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }

    @Test
    @DisplayName("Erro ao salvar registro de pessoas")
    public void savePessoaErrorTest() throws Exception {

        String url = ENDPOINT + "/save";

        BDDMockito.given(service.saveOrUpdatePessoa(any())).willReturn(false);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Sucesso ao editar registro de pessoas")
    public void editPessoaSucessTest() throws Exception {

        String url = ENDPOINT + "/edit/1";

        BDDMockito.given(service.getPessoaById(anyLong())).willReturn(Optional.of(new Pessoa()));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }


    @Test
    @DisplayName("Erro ao editar registro de pessoas")
    public void editPessoaErrorTest() throws Exception {

        String url = ENDPOINT + "/edit/1";

        BDDMockito.given(service.getPessoaById(anyLong())).willReturn(Optional.empty());

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }

    @Test
    @DisplayName("Sucesso ao editar e salvar registro de pessoas")
    public void editSavePessoaSucessTest() throws Exception {

        String url = ENDPOINT + "/editSave";

        BDDMockito.given(service.saveOrUpdatePessoa(any())).willReturn(true);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Erro ao editar e salvar registro de pessoas")
    public void editSavePessoaErrorTest() throws Exception {

        String url = ENDPOINT + "/editSave";

        BDDMockito.given(service.saveOrUpdatePessoa(any())).willReturn(false);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Sucesso ao deletar registro de pessoas")
    public void deletePessoaSucessTest() throws Exception {

        String url = ENDPOINT + "/delete/1";

        BDDMockito.given(service.deletePessoa(any())).willReturn(true);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


    @Test
    @DisplayName("Erro ao deletar registro de pessoas")
    public void deletePessoaErrorTest() throws Exception {

        String url = ENDPOINT + "/delete/1";

        BDDMockito.given(service.deletePessoa(any())).willReturn(false);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isFound());


    }


}
