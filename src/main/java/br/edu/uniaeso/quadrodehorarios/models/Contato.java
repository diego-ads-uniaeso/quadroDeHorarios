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
@Table(name = "contato")
public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idContatos;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = false)
    private Boolean reclamacao;

    @Column(nullable = false)
    private Boolean elogio;
}
