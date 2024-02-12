package com.projeto.carteirinha.repository;

import com.projeto.carteirinha.entity.Estudante;

public record EstudanteResponseDTO(Long id, String nome, String email, Long matricula, String endereco) {

    public EstudanteResponseDTO(Estudante estudante){
        this(
                estudante.getId(),
                estudante.getNome(),
                estudante.getEmail(),
                estudante.getMatricula(),
                estudante.getEndereco()
        );
    }
}
