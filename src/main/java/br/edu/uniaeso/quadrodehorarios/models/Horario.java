package br.edu.uniaeso.quadrodehorarios.models;

import lombok.Data;

@Data
public class Horario {

    private String horarioInicio;

    private String horarioFim;

    private Professor professor;

    private Disciplina disciplina;

    public Horario(String horarioInicio, String horarioFim) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
    }
}
