package me.dio.academia.digital.web.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaService;
import me.dio.academia.digital.web.dto.AvaliacaoFisicaForm;
import me.dio.academia.digital.web.dto.AvaliacaoFisicaUpdateForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {
    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    public ResponseEntity<AvaliacaoFisica> create(@RequestBody AvaliacaoFisicaForm avaliacaoFisicaForm) {
       AvaliacaoFisica avaliacaoFisica =  avaliacaoFisicaService.create(avaliacaoFisicaForm);
        return ResponseEntity.status(HttpStatus.CREATED).body(avaliacaoFisica);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> findById(@PathVariable Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.getById(id);
        return ResponseEntity.ok().body(avaliacaoFisica);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisica>> findAll() {
        List<AvaliacaoFisica> avaliacaoFisicaList = avaliacaoFisicaService.findAll();
        return ResponseEntity.ok().body(avaliacaoFisicaList);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AvaliacaoFisica> update(@PathVariable Long id, @RequestBody AvaliacaoFisicaUpdateForm avaliacaoFisicaUpdateForm) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaService.update(
                id, avaliacaoFisicaUpdateForm.getPeso(), avaliacaoFisicaUpdateForm.getAltura());
        return ResponseEntity.ok().body(avaliacaoFisica);
    }


}
