package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.entities.Professor;

import java.util.List;

public interface ProfessorService {

    Professor save(Professor professor);

    void update(Professor professor);

    void delete(Long id);

    Professor findById(Long id);

    List<Professor> findAll();

    Professor findByMatricula(String matricula);
}
