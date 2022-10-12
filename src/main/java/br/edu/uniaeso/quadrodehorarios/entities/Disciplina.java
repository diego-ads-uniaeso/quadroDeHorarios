package br.edu.uniaeso.quadrodehorarios.entities;

import lombok.*;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Long idDisciplina;

    @Column(unique = true, nullable = false, name = "cod_disciplina")
    private String codDisciplina;

    @Column(unique = true, nullable = false)
    private String nome;

}
