package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;

import java.util.List;

public interface DisciplinaRepository {

    Disciplina save(Disciplina disciplina);

    void update(Disciplina disciplina);

    void delete(Long id);

    Disciplina findById(Long id);

    List<Disciplina> findAll();

    public Disciplina findByCodDisciplina(String codDisciplina);

    public Disciplina findByNome(String nome);

}
