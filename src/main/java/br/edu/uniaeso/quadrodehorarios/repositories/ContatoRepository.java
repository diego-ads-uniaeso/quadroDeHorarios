package br.edu.uniaeso.quadrodehorarios.repositories;

import br.edu.uniaeso.quadrodehorarios.models.Contato;

import java.util.List;
import java.util.UUID;

public interface ContatoRepository {
    Contato save(Contato contato);
}
