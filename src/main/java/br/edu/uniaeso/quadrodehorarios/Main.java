package br.edu.uniaeso.quadrodehorarios;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.models.GradeHorario;
import br.edu.uniaeso.quadrodehorarios.models.Horario;
import br.edu.uniaeso.quadrodehorarios.models.Professor;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Disciplina d = new Disciplina(null, "IA", "Inteligência Artificial");

        List<Disciplina> disciplinas = new ArrayList<>();

        disciplinas.add(d);

        Professor p = new Professor(null, "Diego", "123456", disciplinas);

        GradeHorario gH = new GradeHorario();

        Horario h = new Horario("00:00", "01:00", p, d);

        gH.placeHorario(h);

        System.out.println(gH.toString());
    }
}
