package com.tp3.empresa_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tp3.empresa_api.entity.Funcionario;
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
class FuncionarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarFuncionario() throws Exception {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Maria");
        funcionario.setCargo("Analista");
        funcionario.setSalario(3000.0);

        mockMvc.perform(post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(funcionario)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Maria"))
                .andExpect(jsonPath("$.cargo").value("Analista"));
    }

    @Test
    void deveRetornar404SeFuncionarioNaoExistir() throws Exception {
        mockMvc.perform(get("/funcionarios/999"))
                .andExpect(status().isNotFound());
    }
}
