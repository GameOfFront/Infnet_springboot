package com.tp3.empresa_api;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.tp3.empresa_api.entity.Produto;
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
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarProduto() throws Exception {
        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setPreco(3500.0);
        produto.setQuantidade(10);

        mockMvc.perform(post("/produtos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(produto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Notebook"))
                .andExpect(jsonPath("$.preco").value(3500.0));
    }

    @Test
    void deveRetornar404SeProdutoNaoExistir() throws Exception {
        mockMvc.perform(get("/produtos/999"))
                .andExpect(status().isNotFound());
    }
}
