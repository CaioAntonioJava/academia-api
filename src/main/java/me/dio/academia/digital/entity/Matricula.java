package me.dio.academia.digital.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matriculas")
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

  @Column(name = "data_matricula")
  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
