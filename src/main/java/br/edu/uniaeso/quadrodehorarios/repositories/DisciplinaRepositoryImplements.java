package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.UUID;

@Repository
public class DisciplinaRepositoryImplements extends AbstractRepository<Disciplina, Long> implements DisciplinaRepository {

    @Override
    public Disciplina findByCodDisciplinaOrNome(String codDisciplina, String nome) {
        try {
            return getEntityManager().createQuery("select d from Disciplina d where d.codDisciplina = '" + codDisciplina
                    + "'" + " or d.nome = '" + nome + "'", Disciplina.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
