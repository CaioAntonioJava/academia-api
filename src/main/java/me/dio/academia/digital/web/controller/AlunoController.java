package me.dio.academia.digital.web.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.service.impl.AlunoService;
import me.dio.academia.digital.web.dto.AlunoForm;
import me.dio.academia.digital.web.dto.mapper.AlunoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> create (@RequestBody AlunoForm alunoForm) {
        Aluno newAluno = alunoService.create(AlunoMapper.toAluno(alunoForm));
        return ResponseEntity.status(HttpStatus.CREATED).body(newAluno);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id) {
         Aluno aluno=  alunoService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

}
