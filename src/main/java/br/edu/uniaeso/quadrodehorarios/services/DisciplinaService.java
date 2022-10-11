package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;

import java.util.List;

public interface DisciplinaService {

    Disciplina save(Disciplina disciplina);

    void update(Disciplina disciplina);

    void delete(Long id);

    Disciplina findById(Long id);

    List<Disciplina> findAll();

    Disciplina findByCodDisciplina(String codDisciplina);
}
