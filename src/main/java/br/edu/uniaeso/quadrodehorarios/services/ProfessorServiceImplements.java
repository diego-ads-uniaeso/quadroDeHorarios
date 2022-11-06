package br.edu.uniaeso.quadrodehorarios.services;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.models.Professor;
import br.edu.uniaeso.quadrodehorarios.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    public Professor update(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }

    @Override
    public Professor findById(UUID id) {
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

    @Override
    public Professor findByDisciplina(UUID idDisciplina) {
        return repository.findByDisciplina(idDisciplina);
    }

    @Override
    public String generateMatricula() {
        Calendar cal = GregorianCalendar.getInstance();
        String matricula = String.valueOf(cal.get(Calendar.YEAR));
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            matricula += String.valueOf(random.nextInt(10));
        }
        Professor prof = repository.findByMatricula(matricula);
        if (prof != null) {
            generateMatricula();
        }
        return matricula;
    }
}
