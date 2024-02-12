package com.projeto.carteirinha.entity;

import com.projeto.carteirinha.repository.EstudanteRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "estudantes")
public class Estudante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private Long matricula;
    private String endereco;

    public Estudante(EstudanteRequestDTO estudanteRequestDTO){
        this.nome = estudanteRequestDTO.nome() ;
        this.email = estudanteRequestDTO.email();
        this.matricula = estudanteRequestDTO.matricula();
        this.endereco = estudanteRequestDTO.endereco();
    }
}
