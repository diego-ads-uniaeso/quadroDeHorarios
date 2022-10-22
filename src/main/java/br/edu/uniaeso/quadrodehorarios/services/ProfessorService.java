package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.models.Professor;

import java.util.List;
import java.util.UUID;

public interface ProfessorService {

    Professor save(Professor professor);

    Professor update(Professor professor);

    void delete(UUID id);

    Professor findById(UUID id);

    List<Professor> findAll();

    Professor findByMatricula(String matricula);

    public Professor findByDisciplina(UUID idDisciplina);
}
