package com.projeto.carteirinha.service;

import com.projeto.carteirinha.entity.Estudante;
import com.projeto.carteirinha.repository.EstudanteRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EstudanteService {
    private EstudanteRepository estudanteRepository;


    public List<Estudante> create(Estudante estudante){
        estudanteRepository.save(estudante);
        return list();
    }
    public List<Estudante> list(){
        Sort sort = Sort.by("matricula").and(
                Sort.by("nome"));
        return estudanteRepository.findAll(sort);
    }

    public List<Estudante> update(Estudante estudante){
        estudanteRepository.save(estudante);
        return list();
    }

    public List<Estudante> delete(Long id){
        estudanteRepository.deleteById(id);
        return list();
    }
}
