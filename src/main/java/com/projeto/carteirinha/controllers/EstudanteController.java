package com.projeto.carteirinha.controllers;

import com.projeto.carteirinha.entity.Estudante;
import com.projeto.carteirinha.service.EstudanteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@Controller
@RequestMapping("/estudantes")

public class EstudanteController {
    private EstudanteService estudanteService;

    @PostMapping
    @ResponseBody
    List<Estudante> create(Estudante estudante){
        return estudanteService.create(estudante);

    }
    @GetMapping
    @ResponseBody
    List<Estudante> list(){

        return  estudanteService.list();
    }
    @PutMapping
    @ResponseBody
    List<Estudante> update(Estudante estudante){

        return estudanteService.update(estudante);
    }
    @DeleteMapping("{id}")
    List<Estudante> delete(@PathVariable("id") Long id){

        return estudanteService.delete(id);
    }
}
