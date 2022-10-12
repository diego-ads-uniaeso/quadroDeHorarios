package br.edu.uniaeso.quadrodehorarios.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    private Long idProfessor;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String matricula;

    @ManyToMany
    @JoinColumn(name = "id_disciplinas")
    private List<Disciplina> disciplinas;

    private Boolean horario[][];
}
