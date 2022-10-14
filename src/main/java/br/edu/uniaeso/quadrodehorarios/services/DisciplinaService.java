package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;

import java.util.List;

public interface DisciplinaService {

    Disciplina save(Disciplina disciplina);

    Disciplina update(Disciplina disciplina);

    void delete(Long id);

    Disciplina findById(Long id);

    List<Disciplina> findAll();

    Disciplina findByCodDisciplina(String codDisciplina);
}
