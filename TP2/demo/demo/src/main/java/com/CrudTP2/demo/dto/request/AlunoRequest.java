package com.CrudTP2.demo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlunoRequest {

    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "O curso é obrigatório")
    private String curso;
}
