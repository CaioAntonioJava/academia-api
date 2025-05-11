package me.dio.academia.digital.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaForm {


  @Positive(message = "O id do aluno precisa ser positivo.")
  @NotNull(message = "Preencha o campo corretamente.")
  private Long alunoId;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = " '${validatedValue}' precisa ser positivo.")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = " '${validatedValue}' precisa ser positivo.")
  @DecimalMin(value = "140", message = "'${validatedValue}' precisa ser no mínimo {value}.")
  private double altura;
}
