package com.projeto.carteirinha.controllers;

import com.projeto.carteirinha.entity.Estudante;
import com.projeto.carteirinha.repository.EstudanteRepository;
import com.projeto.carteirinha.repository.EstudanteRequestDTO;
import com.projeto.carteirinha.repository.EstudanteResponseDTO;
import com.projeto.carteirinha.service.EstudanteService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
@RequestMapping("/carteirinhas")

public class EstudanteController {
    private EstudanteService estudanteService;
    private EstudanteRepository estudanteRepository;



    /*
    @PostMapping
    List<Estudante> create(@RequestBody Estudante estudante){
        return estudanteService.create(estudante);
    }
    */
    @PostMapping
    public ResponseEntity<Estudante> create(@RequestBody EstudanteRequestDTO dto) {
        Estudante usuario = new Estudante(dto);
        estudanteRepository.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);


    }
    @GetMapping
    @ResponseBody
    List<EstudanteResponseDTO> getAll(){

        List<EstudanteResponseDTO> estudanteList = estudanteRepository.findAll().stream().map(EstudanteResponseDTO::new).toList();
        return estudanteList;
    }
    @PutMapping
    ResponseEntity update(@RequestBody  @Validated EstudanteRequestDTO dto){
        Optional<Estudante> optionalEstudante = estudanteRepository.findById(dto.id());
        if (optionalEstudante.isPresent()) {
            Estudante estudante = optionalEstudante.get();
            estudante.setNome(dto.nome());
            estudante.setEmail(dto.email());
            estudante.setMatricula(dto.matricula());
            estudante.setEndereco(dto.endereco());
            return ResponseEntity.ok(estudante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*
    @DeleteMapping("{id}")
    List<Estudante> delete(@PathVariable("id") Long id){

         estudanteService.delete(id);
         return estudanteService.list();
    }

     */
    @DeleteMapping("{id}")
    ResponseEntity<String> delete(@PathVariable("id") Long id) {
        Optional<Estudante> optionalEstudante = estudanteRepository.findById(id);
        if (optionalEstudante.isPresent()) {
            estudanteService.delete(id);
            return ResponseEntity.ok("Estudante removido com sucesso.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
