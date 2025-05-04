package me.dio.academia.digital.web.dto.mapper;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.web.dto.AlunoForm;
import me.dio.academia.digital.web.dto.AlunoUpdateForm;
import org.modelmapper.ModelMapper;

public class AlunoMapper {

    public static Aluno toAluno (AlunoForm alunoForm ) {
        return new ModelMapper().map(alunoForm, Aluno.class);
    }

    public static Aluno updateAluno (AlunoUpdateForm alunoUpdateForm ) {
        return new ModelMapper().map(alunoUpdateForm, Aluno.class);
    }
}
