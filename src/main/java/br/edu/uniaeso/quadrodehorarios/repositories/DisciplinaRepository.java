package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;

import java.util.List;

public interface DisciplinaRepository {

    Disciplina save(Disciplina disciplina);

    Disciplina update(Disciplina disciplina);

    void delete(Long id);

    Disciplina findById(Long id);

    List<Disciplina> findAll();

    Disciplina findByCodDisciplina(String codDisciplina);

    Disciplina findByNome(String nome);

}
