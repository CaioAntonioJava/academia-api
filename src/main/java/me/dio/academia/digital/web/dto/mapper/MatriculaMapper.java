package me.dio.academia.digital.web.dto.mapper;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.web.dto.MatriculaForm;
import org.modelmapper.ModelMapper;

public class MatriculaMapper {

    public static Matricula toMatricula(MatriculaForm matriculaForm) {
        return new ModelMapper().map(matriculaForm, Matricula.class);
    }
}
