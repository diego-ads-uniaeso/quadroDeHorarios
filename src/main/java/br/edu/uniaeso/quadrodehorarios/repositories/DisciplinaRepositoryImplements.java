package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;
import org.springframework.stereotype.Repository;

@Repository
public class DisciplinaRepositoryImplements extends AbstractRepository<Disciplina, Long> implements DisciplinaRepository {

    @Override
    public Disciplina findByCodDisciplina(String codDisciplina) {
        return getEntityManager().createQuery("select d from Disciplina d where d.codDisciplina = '" + codDisciplina
                + "'", Disciplina.class).getSingleResult();
    }

    @Override
    public Disciplina findByNome(String nome) {
        return getEntityManager().createQuery("select d from Disciplina d where d.nome = '" + nome
                + "'", Disciplina.class).getSingleResult();
    }
}
