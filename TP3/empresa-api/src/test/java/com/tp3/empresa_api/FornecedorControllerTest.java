package com.tp3.empresa_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tp3.empresa_api.entity.Fornecedor;
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
class FornecedorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarFornecedor() throws Exception {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome("Tech Supply");
        fornecedor.setCnpj("12345678000199");
        fornecedor.setContato("contato@techsupply.com");

        mockMvc.perform(post("/fornecedores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fornecedor)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Tech Supply"))
                .andExpect(jsonPath("$.cnpj").value("12345678000199"));
    }

    @Test
    void deveRetornar404SeFornecedorNaoExistir() throws Exception {
        mockMvc.perform(get("/fornecedores/999"))
                .andExpect(status().isNotFound());
    }
}
