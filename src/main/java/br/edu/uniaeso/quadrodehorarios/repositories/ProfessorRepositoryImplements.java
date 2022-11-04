package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.models.Professor;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.UUID;

@Repository
public class ProfessorRepositoryImplements extends AbstractRepository<Professor, Long> implements ProfessorRepository {

    @Override
    public Professor findByMatricula(String matricula) {
        try {
            return getEntityManager().createQuery("select d from Professor d where d.matricula = '" + matricula
                    + "'", Professor.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Professor findByNome(String nome) {
        return getEntityManager().createQuery("select d from Professor d where d.nome = '" + nome
                + "'", Professor.class).getSingleResult();
    }

    @Override
    public Professor findByDisciplina(UUID idDisciplina) {
        try{
            return getEntityManager().createQuery("select p from Professor p inner join p.disciplinas d where d.idDisciplina = '"
                    + idDisciplina + "'", Professor.class).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
