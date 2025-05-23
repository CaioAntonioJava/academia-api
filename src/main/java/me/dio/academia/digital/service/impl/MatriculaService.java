package me.dio.academia.digital.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;

    @Transactional
    public Matricula create(Matricula matricula) {
        Matricula newMatricula = new Matricula();

        Aluno aluno = alunoRepository.findById(matricula.getId()).orElseThrow(
                () -> new RuntimeException("Aluno não Encontrado")
        );

        newMatricula.setAluno(aluno);


        return matriculaRepository.save(newMatricula);
    }


    @ReadOnlyProperty
    public Matricula getById(Long id) {
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Matricula não encontrada")
        );
        return matricula;
    }

    @ReadOnlyProperty
    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        getById(id);
        try {
            matriculaRepository.deleteById(id);
        } catch (Exception exception) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas");
        }
    }
}
