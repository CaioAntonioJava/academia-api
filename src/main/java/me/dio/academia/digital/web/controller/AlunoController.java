package me.dio.academia.digital.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.service.impl.AlunoService;
import me.dio.academia.digital.web.dto.AlunoForm;
import me.dio.academia.digital.web.dto.AlunoUpdateForm;
import me.dio.academia.digital.web.dto.mapper.AlunoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody AlunoForm alunoForm) {
        Aluno newAluno = alunoService.create(AlunoMapper.toAluno(alunoForm));
        return ResponseEntity.status(HttpStatus.CREATED).body(newAluno);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> alunoList = alunoService.findAll();
        return ResponseEntity.ok().body(alunoList);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody AlunoUpdateForm alunoUpdateForm) {
        Aluno updateObj = alunoService.updateDadosAluno
                (id, alunoUpdateForm.getNome(), alunoUpdateForm.getBairro(), alunoUpdateForm.getDataDeNascimento());
        return ResponseEntity.ok().body(updateObj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
