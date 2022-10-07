package br.edu.uniaeso.quadrodehorarios.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;

    @Column(unique = true, nullable = false)
    private String cod_disciplina;

    @Column(unique = true, nullable = false)
    private String nome;



}
