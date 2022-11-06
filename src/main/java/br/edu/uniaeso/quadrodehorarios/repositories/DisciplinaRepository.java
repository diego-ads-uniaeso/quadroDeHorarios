package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;

import java.util.List;
import java.util.UUID;

public interface DisciplinaRepository {

    Disciplina save(Disciplina disciplina);

    Disciplina update(Disciplina disciplina);

    void delete(UUID id);

    Disciplina findById(UUID id);

    List<Disciplina> findAll();

    Disciplina findByCodDisciplinaOrNome(String codDisciplina, String nome);

}
