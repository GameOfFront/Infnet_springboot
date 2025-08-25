package com.CrudTP2.demo.controller;

import com.CrudTP2.demo.dto.request.AlunoRequest;
import com.CrudTP2.demo.dto.response.AlunoResponse;
import com.CrudTP2.demo.service.AlunoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoResponse> salvar(@Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.status(201).body(alunoService.salvar(request));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listarTodos() {
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alunoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponse> atualizar(@PathVariable Long id, @Valid @RequestBody AlunoRequest request) {
        return ResponseEntity.ok(alunoService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
