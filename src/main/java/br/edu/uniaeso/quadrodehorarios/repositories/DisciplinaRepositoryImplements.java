package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.UUID;

@Repository
public class DisciplinaRepositoryImplements extends AbstractRepository<Disciplina, Long> implements DisciplinaRepository {

    @Override
    public Disciplina findByCodDisciplina(String codDisciplina) {
        try {
            return getEntityManager().createQuery("select d from Disciplina d where d.codDisciplina = '" + codDisciplina
                    + "'", Disciplina.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Disciplina findByNome(String nome) {
        try {
            return getEntityManager().createQuery("select d from Disciplina d where d.nome = '" + nome
                    + "'", Disciplina.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
