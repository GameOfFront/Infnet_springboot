package com.tp3.empresa_api.service;




import com.tp3.empresa_api.entity.Funcionario;
import com.tp3.empresa_api.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Optional<Funcionario> atualizar(Long id, Funcionario funcionarioAtualizado) {
        return repository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioAtualizado.getNome());
            funcionario.setCargo(funcionarioAtualizado.getCargo());
            funcionario.setSalario(funcionarioAtualizado.getSalario());
            return repository.save(funcionario);
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
