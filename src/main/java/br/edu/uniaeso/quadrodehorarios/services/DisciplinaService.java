package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;

import java.util.List;
import java.util.UUID;

public interface DisciplinaService {

    Disciplina save(Disciplina disciplina);

    Disciplina update(Disciplina disciplina);

    void delete(UUID id);

    Disciplina findById(UUID id);

    List<Disciplina> findAll();

    Disciplina findByCodDisciplina(String codDisciplina);

    Disciplina findByNome(String nome);
}
