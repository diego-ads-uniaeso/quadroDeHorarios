package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.entities.Professor;

public class ProfessorRepositoryImplements extends AbstractRepository<Professor,Long> implements ProfessorRepository{

    @Override
    public Professor findByMatricula(String matricula) {
        return getEntityManager().createQuery("select d from Professor d where d.matricula = '" + matricula
                + "'", Professor.class).getSingleResult();
    }

    @Override
    public Professor findByNome(String nome) {
        return getEntityManager().createQuery("select d from Professor d where d.nome = '" + nome
                + "'", Professor.class).getSingleResult();
    }
}
