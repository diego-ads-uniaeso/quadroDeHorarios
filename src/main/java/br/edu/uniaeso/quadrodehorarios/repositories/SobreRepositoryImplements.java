package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Sobre;

import java.util.List;

public class SobreRepositoryImplements extends AbstractRepository<Sobre, Long> implements SobreRepository{
    @Override
    public List<Sobre> findall() {
        return null;
    }
}
