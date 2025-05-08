package me.dio.academia.digital.web.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.service.impl.MatriculaService;
import me.dio.academia.digital.web.dto.MatriculaForm;
import me.dio.academia.digital.web.dto.mapper.MatriculaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<Matricula> create(@RequestBody MatriculaForm matriculaForm) {
        Matricula matricula = matriculaService.create(MatriculaMapper.toMatricula(matriculaForm));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> getById(@PathVariable Long id) {
        Matricula matricula = matriculaService.getById(id);
        return ResponseEntity.ok().body(matricula);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> getAll() {
        List<Matricula> matriculaList = matriculaService.getAll();
        return ResponseEntity.ok().body(matriculaList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        matriculaService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
