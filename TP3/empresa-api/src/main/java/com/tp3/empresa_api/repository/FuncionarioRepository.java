package com.tp3.empresa_api.repository;


import com.tp3.empresa_api.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
