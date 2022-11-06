package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Contato;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ContatoRepositoryImplements extends AbstractRepository<Contato, Long> implements ContatoRepository {
}
