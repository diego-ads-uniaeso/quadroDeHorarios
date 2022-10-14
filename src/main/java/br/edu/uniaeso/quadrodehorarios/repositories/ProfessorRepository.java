package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Professor;

import java.util.List;

public interface ProfessorRepository {
    Professor save(Professor professor);

    void update(Professor professor);

    void delete(Long id);

    Professor findById(Long id);

    List<Professor> findAll();

    public Professor findByMatricula(String matricula);

    public Professor findByNome(String nome);
}
