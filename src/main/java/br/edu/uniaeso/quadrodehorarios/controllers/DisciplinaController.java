package br.edu.uniaeso.quadrodehorarios.controllers;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.models.Professor;
import br.edu.uniaeso.quadrodehorarios.services.DisciplinaService;
import br.edu.uniaeso.quadrodehorarios.services.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @Autowired
    private ProfessorService serviceProfessor;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Disciplina disciplina) {
        Map<HttpStatus, String> message = new HashMap<>();
        Disciplina base = null;
        base = service.findByCodDisciplinaOrNome(disciplina.getCodDisciplina(), disciplina.getNome());
        if(base != null) {
            if (base.getCodDisciplina().equals(disciplina.getCodDisciplina())) {
                message.put(HttpStatus.CONFLICT, "Código da disciplina já existente!");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
            if (base.getNome().equals(disciplina.getNome())) {
                message.put(HttpStatus.CONFLICT, "Nome da disciplina já existente!");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
        }
        if(disciplina.getCodDisciplina().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Favor preencher o código da disciplina!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if(disciplina.getNome().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Favor preencher o nome da disciplina!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        service.save(disciplina);
        message.put(HttpStatus.CREATED, "Disciplina cadastrada com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Disciplina disciplina) {
        Map<HttpStatus, String> message = new HashMap<>();
        Disciplina base = service.findById(disciplina.getIdDisciplina());
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Disciplina não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        if(disciplina.getCodDisciplina().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Favor preencher o código da disciplina!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if(disciplina.getNome().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Favor preencher o nome da disciplina!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        service.update(disciplina);
        message.put(HttpStatus.ACCEPTED, "Disciplina alterada com sucesso!");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") UUID idDisciplina) {
        Map<HttpStatus, String> message = new HashMap<>();
        Disciplina base = service.findById(idDisciplina);
        Professor professor = serviceProfessor.findByDisciplina(idDisciplina);
        if(professor != null) {
            message.put(HttpStatus.CONFLICT, "Disciplina já associada a um professor, não pode ser excluída!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Disciplina não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        service.delete(idDisciplina);
        message.put(HttpStatus.ACCEPTED, "Disciplina deletada com sucesso!");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") UUID id) {
        Map<HttpStatus, String> message = new HashMap<>();
        Disciplina base = service.findById(id);
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Disciplina não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(base);
    }

    @GetMapping("/find/byCodDisciplina/{codDisciplina}")
    public ResponseEntity<Object> findByCodDisciplina(@PathVariable(value = "codDisciplina") String codDisciplina) {
        Map<HttpStatus, String> message = new HashMap<>();
        if (codDisciplina.isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Deve informar o código da disciplina para realizar a pesquisa!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        Disciplina base = null;
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Disciplina não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(base);
    }

    @GetMapping("/find/nome/{nome}")
    public ResponseEntity<Object> findByNome(@PathVariable(value = "nome") String nome) {
        Map<HttpStatus, String> message = new HashMap<>();
        if (nome.isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Deve informar o nome da disciplina para realizar a pesquisa!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        Disciplina base = null;
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Disciplina não encontrada!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(base);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Disciplina>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
