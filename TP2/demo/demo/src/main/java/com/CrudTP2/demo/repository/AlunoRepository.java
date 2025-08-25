package com.CrudTP2.demo.repository;

import com.CrudTP2.demo.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
