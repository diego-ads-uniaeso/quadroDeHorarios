package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.models.Horario;
import br.edu.uniaeso.quadrodehorarios.models.Professor;
import br.edu.uniaeso.quadrodehorarios.repositories.DisciplinaRepository;
import br.edu.uniaeso.quadrodehorarios.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GerarQuadroHorarioServiceImplements implements GerarQuadroHorarioService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void gerarHorario() {
        List<Disciplina> disciplinas = disciplinaRepository.findAll();

        List<Professor> profesores = professorRepository.findAll();

        Horario h1 = new Horario("07:30", "08:20");
        Horario h2 = new Horario("08:20", "09:10");
        Horario h3 = new Horario("09:20", "10:10");
        Horario h4 = new Horario("18:30", "19:20");
        Horario h5 = new Horario("19:20", "20:10");
        Horario h6 = new Horario("20:20", "21:10");
        Horario h7 = new Horario("21:10", "22:00");


    }
}
