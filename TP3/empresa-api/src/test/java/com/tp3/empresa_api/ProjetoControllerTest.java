package com.tp3.empresa_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tp3.empresa_api.entity.Projeto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarProjeto() throws Exception {
        Projeto projeto = new Projeto();
        projeto.setTitulo("Sistema ERP");
        projeto.setOrcamento(50000.0);
        projeto.setResponsavel("Carlos");

        mockMvc.perform(post("/projetos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(projeto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value("Sistema ERP"))
                .andExpect(jsonPath("$.responsavel").value("Carlos"));
    }

    @Test
    void deveRetornar404SeProjetoNaoExistir() throws Exception {
        mockMvc.perform(get("/projetos/999"))
                .andExpect(status().isNotFound());
    }
}

