package me.dio.academia.digital.web.controller;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaService;
import me.dio.academia.digital.web.dto.AvaliacaoFisicaForm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
