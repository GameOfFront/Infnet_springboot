package com.tp3.empresa_api.repository;

import com.tp3.empresa_api.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
