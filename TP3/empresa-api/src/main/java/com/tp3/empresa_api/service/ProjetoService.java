package com.tp3.empresa_api.service;

import com.tp3.empresa_api.entity.Projeto;
import com.tp3.empresa_api.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }

    public List<Projeto> listarTodos() {
        return repository.findAll();
    }

    public Optional<Projeto> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Projeto salvar(Projeto projeto) {
        return repository.save(projeto);
    }

    public Optional<Projeto> atualizar(Long id, Projeto projetoAtualizado) {
        return repository.findById(id).map(projeto -> {
            projeto.setTitulo(projetoAtualizado.getTitulo());
            projeto.setOrcamento(projetoAtualizado.getOrcamento());
            projeto.setResponsavel(projetoAtualizado.getResponsavel());
            return repository.save(projeto);
        });
    }

    public boolean deletar(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}

