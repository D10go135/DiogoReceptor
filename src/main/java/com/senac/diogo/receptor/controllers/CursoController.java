package com.senac.diogo.receptor.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.senac.diogo.receptor.entities.Curso;
import com.senac.diogo.receptor.services.CursoService;

@RestController
@RequestMapping("curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Endpoint para listar todos os cursos disponíveis
    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursosDisponiveis();
        return ResponseEntity.ok(cursos);
    }

    // Endpoint para buscar um curso por ID
    @GetMapping("{id}")
    public ResponseEntity<Curso> buscarCursoPorId(@PathVariable int id) {
        Curso curso = cursoService.listarCursoPorId(id).orElse(null); // Utilizando Optional
        if (curso != null) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Endpoint para adicionar um novo curso
    @PostMapping(value = "adicionarCurso")
    public ResponseEntity<Curso> adicionarCurso(@RequestBody Curso curso) {
        Curso tempCurso = cursoService.adicionarCurso(curso);
        return ResponseEntity.ok(tempCurso);
    }
}