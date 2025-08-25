package com.CrudTP2.demo.service.impl;

import com.CrudTP2.demo.dto.request.AlunoRequest;
import com.CrudTP2.demo.dto.response.AlunoResponse;
import com.CrudTP2.demo.entity.Aluno;
import com.CrudTP2.demo.exception.ResourceNotFoundException;
import com.CrudTP2.demo.repository.AlunoRepository;
import com.CrudTP2.demo.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    public AlunoResponse salvar(AlunoRequest request) {
        Aluno aluno = new Aluno(null, request.getNome(), request.getEmail(), request.getCurso());
        alunoRepository.save(aluno);
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCurso());
    }

    @Override
    public List<AlunoResponse> listarTodos() {
        return alunoRepository.findAll()
                .stream()
                .map(a -> new AlunoResponse(a.getId(), a.getNome(), a.getEmail(), a.getCurso()))
                .toList();
    }

    @Override
    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id " + id));
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCurso());
    }

    @Override
    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id " + id));

        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());
        aluno.setCurso(request.getCurso());

        alunoRepository.save(aluno);
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCurso());
    }

    @Override
    public void deletar(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Aluno não encontrado com id " + id);
        }
        alunoRepository.deleteById(id);
    }
}
