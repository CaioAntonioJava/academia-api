package me.dio.academia.digital.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.web.dto.AvaliacaoFisicaForm;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    private final AlunoRepository alunoRepository;

    public AvaliacaoFisica create(AvaliacaoFisicaForm avaliacaoFisicaForm) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        Aluno aluno = alunoRepository.findById(avaliacaoFisicaForm.getAlunoId()).orElseThrow(
                () -> new RuntimeException("ID de aluno não encontrado"));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(avaliacaoFisicaForm.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaForm.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }


}
