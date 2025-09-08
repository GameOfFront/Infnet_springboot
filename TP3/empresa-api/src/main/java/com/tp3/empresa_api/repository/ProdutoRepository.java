package com.tp3.empresa_api.repository;


import com.tp3.empresa_api.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
