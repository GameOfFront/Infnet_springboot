package com.tp3.empresa_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Pattern(regexp = "\\d{14}", message = "O CNPJ deve conter 14 dígitos numéricos")
    private String cnpj;

    @NotBlank(message = "O contato é obrigatório")
    private String contato;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
}
