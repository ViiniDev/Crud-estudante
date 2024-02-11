package com.projeto.carteirinha.repository;

import com.projeto.carteirinha.entity.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
