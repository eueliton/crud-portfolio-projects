
package com.tomjr.crud.controller;

import com.tomjr.crud.service.impl.MembroService;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MembroControllerTest {

    static String ENDPOINT = "/membro";

    private InputStream is;

    private MockMvc mvc;

    @InjectMocks
    private MembroController controller;

    @Mock
    private MembroService service;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Adicionar membro projeto")
    public void adicionarMembroProjetoTest() throws Exception {

        String url = ENDPOINT + "/idProjeto/1/idPessoa/2";

        BDDMockito.given(service.save(1l, 1l)).willReturn("");

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk());


    }


}
