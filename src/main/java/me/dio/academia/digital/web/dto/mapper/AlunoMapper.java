package me.dio.academia.digital.web.dto.mapper;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.web.dto.AlunoForm;
import org.modelmapper.ModelMapper;

public class AlunoMapper {

    public static Aluno toAluno (AlunoForm alunoForm ) {
        return new ModelMapper().map(alunoForm, Aluno.class);
    }
}
