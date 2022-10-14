package br.edu.uniaeso.quadrodehorarios.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDisciplina;

    @Column(unique = true, nullable = false)
    private String codDisciplina;

    @Column(unique = true, nullable = false)
    private String nome;

}
