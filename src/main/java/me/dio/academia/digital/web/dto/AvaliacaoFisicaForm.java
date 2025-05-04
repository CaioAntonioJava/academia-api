package me.dio.academia.digital.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaForm {

  private Long alunoId;

  private double peso;

  private double altura;
}
