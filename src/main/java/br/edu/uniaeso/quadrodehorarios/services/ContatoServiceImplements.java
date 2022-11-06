package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.models.Contato;
import br.edu.uniaeso.quadrodehorarios.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class ContatoServiceImplements implements ContatoService{

    @Autowired
    ContatoRepository repository;

    @Override
    public Contato save(Contato contato) {
        return repository.save(contato);
    }
}
