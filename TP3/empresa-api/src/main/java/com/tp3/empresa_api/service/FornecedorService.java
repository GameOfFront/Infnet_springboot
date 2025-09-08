package com.tp3.empresa_api.service;

import com.tp3.empresa_api.entity.Fornecedor;
import com.tp3.empresa_api.repository.FornecedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public List<Fornecedor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Optional<Fornecedor> atualizar(Long id, Fornecedor fornecedorAtualizado) {
        return repository.findById(id).map(fornecedor -> {
            fornecedor.setNome(fornecedorAtualizado.getNome());
            fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedor.setContato(fornecedorAtualizado.getContato());
            return repository.save(fornecedor);
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

