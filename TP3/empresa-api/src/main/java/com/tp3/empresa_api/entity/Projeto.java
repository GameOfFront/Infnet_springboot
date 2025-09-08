package com.tp3.empresa_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String titulo;

    @PositiveOrZero(message = "O orçamento deve ser maior ou igual a 0")
    private Double orcamento;

    @NotBlank(message = "O responsável é obrigatório")
    private String responsavel;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Double getOrcamento() { return orcamento; }
    public void setOrcamento(Double orcamento) { this.orcamento = orcamento; }

    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
}
