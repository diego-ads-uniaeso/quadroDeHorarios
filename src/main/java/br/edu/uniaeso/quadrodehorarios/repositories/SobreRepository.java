package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Sobre;

import java.util.List;
import java.util.UUID;

public interface SobreRepository {

    Sobre save(Sobre sobre);

    List<Sobre> findall();

    Sobre findById(UUID id);
}
