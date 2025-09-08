package com.tp3.empresa_api.repository;

import com.tp3.empresa_api.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
