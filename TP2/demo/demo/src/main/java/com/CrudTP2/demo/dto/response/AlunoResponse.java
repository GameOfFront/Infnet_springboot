package com.CrudTP2.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AlunoResponse {
    private Long id;
    private String nome;
    private String email;
    private String curso;
}
