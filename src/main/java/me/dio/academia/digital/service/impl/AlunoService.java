package me.dio.academia.digital.service.impl;

import lombok.RequiredArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.repository.AlunoRepository;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    @Transactional
    public Aluno create(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @ReadOnlyProperty
    public Aluno findById(Long id) {
        return alunoRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("""
                        ALUNO NÃO ENCONTRADO
                        """))
        );
    }

    @ReadOnlyProperty
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Transactional
    public Aluno updateDadosAluno(Long id, String nome, String bairro, LocalDate dataNascimento) {
        Aluno update = findById(id);
        update.setNome(nome);
        update.setBairro(bairro);
        update.setDataDeNascimento(dataNascimento);
        return alunoRepository.save(update);
    }

    @Transactional
    public void delete(Long id) {
        findById(id);
        try {
            alunoRepository.deleteById(id);
        } catch (Exception exception) {
            throw new RuntimeException("Há entidades relacionadas ao aluno");
        }
    }
}
