package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Professor;

import java.util.List;
import java.util.UUID;

public interface ProfessorRepository {
    Professor save(Professor professor);

    Professor update(Professor professor);

    void delete(UUID id);

    Professor findById(UUID id);

    List<Professor> findAll();

    public Professor findByMatricula(String matricula);

    public Professor findByNome(String nome);
}
