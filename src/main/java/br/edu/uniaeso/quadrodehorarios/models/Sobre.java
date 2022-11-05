package br.edu.uniaeso.quadrodehorarios.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sobre")
public class Sobre implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sobreNos;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String conteudo;

    @Column(unique = true, nullable = false)
    private Boolean reclamacao;

    @Column(unique = true, nullable = false)
    private Boolean elogio;
}
