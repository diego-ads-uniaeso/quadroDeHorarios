package br.edu.uniaeso.quadrodehorarios.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professores")
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProfessor;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String matricula;

    @ManyToMany
    @JoinTable(name = "professor_disciplina",
            joinColumns = @JoinColumn(name = "id_professor"),
            inverseJoinColumns = @JoinColumn(name = "id_disciplina"))

    private List<Disciplina> disciplinas;

    //private Boolean[][] disponibilidade;
}
