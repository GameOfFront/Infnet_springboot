package com.CrudTP2.demo.service;

import com.CrudTP2.demo.dto.request.AlunoRequest;
import com.CrudTP2.demo.dto.response.AlunoResponse;

import java.util.List;

public interface AlunoService {
    AlunoResponse salvar(AlunoRequest request);
    List<AlunoResponse> listarTodos();
    AlunoResponse buscarPorId(Long id);
    AlunoResponse atualizar(Long id, AlunoRequest request);
    void deletar(Long id);
}
