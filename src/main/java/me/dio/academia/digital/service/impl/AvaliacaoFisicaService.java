package me.dio.academia.digital.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.web.dto.AvaliacaoFisicaForm;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    private final AlunoRepository alunoRepository;

    @Transactional
    public AvaliacaoFisica create(AvaliacaoFisicaForm avaliacaoFisicaForm) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();

        Aluno aluno = alunoRepository.findById(avaliacaoFisicaForm.getAlunoId()).orElseThrow(
                () -> new RuntimeException("ID de aluno não encontrado"));

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(avaliacaoFisicaForm.getPeso());
        avaliacaoFisica.setAltura(avaliacaoFisicaForm.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @ReadOnlyProperty
    public AvaliacaoFisica getById(Long id) {
        return avaliacaoFisicaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Avaliação Física não encontrada")
        );
    }

    @ReadOnlyProperty
    public List<AvaliacaoFisica> findAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Transactional
    public AvaliacaoFisica update(Long id, double peso, double altura) {
        AvaliacaoFisica avaliacaoFisica = getById(id);
        avaliacaoFisica.setPeso(peso);
        avaliacaoFisica.setAltura(altura);
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }
}
