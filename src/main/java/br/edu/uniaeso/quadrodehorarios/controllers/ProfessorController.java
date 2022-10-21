package br.edu.uniaeso.quadrodehorarios.controllers;


import br.edu.uniaeso.quadrodehorarios.models.Professor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import br.edu.uniaeso.quadrodehorarios.services.ProfessorService;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Professor professor) {
        Map<HttpStatus, String> message = new HashMap<>();
        Professor base = service.findByMatricula(professor.getMatricula());
        if(base != null) {
            if(base.getMatricula().equals(professor.getMatricula())) {
                message.put(HttpStatus.CONFLICT, "Matricula existente!");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
            if(base.getNome().equals(professor.getNome())) {
                message.put(HttpStatus.CONFLICT, "Nome do professor cadastrado!");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
        }
        service.save(professor);
        message.put(HttpStatus.CONFLICT, "Professor cadastrado com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(professor));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Professor professor) {
        Map<HttpStatus, String> message = new HashMap<>();
        Professor base = service.findByMatricula(professor.getMatricula());
        if(base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        if(base.getMatricula().equals(professor.getMatricula()) && base.getNome().equals(professor.getNome())) {
            message.put(HttpStatus.CONFLICT, "Não foi possível alterar");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        message.put(HttpStatus.ACCEPTED, "Professor atualizado com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(service.update(professor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") UUID id) {
        Map<HttpStatus, String> message = new HashMap<>();
        Professor base = service.findById(id);
        if(base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        service.delete(id);
        message.put(HttpStatus.ACCEPTED, "Professor removido com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso!");
    }

    @GetMapping("/find/byId/{idProfessor}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idProfessor") UUID idProfessor) {
        Map<HttpStatus, String> message = new HashMap<>();
        if(idProfessor != null) {
            message.put(HttpStatus.CONFLICT, "Por favor, informar o id do professor!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        Professor base = service.findById(idProfessor);
        if(base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não enctonrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(idProfessor));
    }

    @GetMapping("/find/byMatricula/{matricula}")
    public ResponseEntity<Object> findByMatricula(@PathVariable(value = "matricula") String matricula) {
        Map<HttpStatus, String> message = new HashMap<>();
        if(matricula.isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Por favor, informar a matricula para pesquisar o professor.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        Professor base = service.findByMatricula(matricula);
        if(base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(service.findByMatricula(matricula));
    }

    @GetMapping("/find/nome/{nome}")
    public ResponseEntity<Object> findByName(@PathVariable(value = "nome") String nome) {
        Map<HttpStatus, String> message = new HashMap<>();
        if(nome.isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Por favor, informar nome do professor.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        Professor base = service.findByNome(nome);
        if(base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.status(HttpStatus.OK).body(base);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Professor>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
