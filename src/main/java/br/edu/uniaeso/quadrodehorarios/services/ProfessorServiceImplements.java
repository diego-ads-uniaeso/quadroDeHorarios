package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.entities.Professor;
import br.edu.uniaeso.quadrodehorarios.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Service
@Transactional(readOnly = false)
public class ProfessorServiceImplements implements ProfessorService {

    private static final Logger logger = LogManager.getLogger(ProfessorServiceImplements.class.getName());

    @Autowired
    private ProfessorRepository repository;

    @Override
    public Professor save(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public void update(Professor professor) {
        repository.save(professor);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Professor findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Professor> findAll() {
        return repository.findAll();
    }

    @Override
    public Professor findByMatricula(String matricula) {
        return repository.findByMatricula(matricula);
    }
}
