package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;
import br.edu.uniaeso.quadrodehorarios.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
@Transactional(readOnly = false)
public class DisciplinaServiceImplements implements DisciplinaService {

    private static final Logger logger = LogManager.getLogger(DisciplinaServiceImplements.class.getName());

    @Autowired
    private DisciplinaRepository repository;

    @Override
    public Disciplina save(Disciplina disciplina) {
        return repository.save(disciplina);
    }

    @Override
    public void update(Disciplina disciplina) {
        repository.save(disciplina);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Disciplina findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Disciplina findByCodDisciplina(String codDisciplina) {
        return repository.findByCodDisciplina(codDisciplina);
    }

    @Override
    public List<Disciplina> findAll() {
        return repository.findAll();
    }
}
