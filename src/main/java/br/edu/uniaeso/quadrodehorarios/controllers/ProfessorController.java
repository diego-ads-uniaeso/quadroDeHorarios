package br.edu.uniaeso.quadrodehorarios.controllers;


import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
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
        Professor base = null;
        base = service.findByMatricula(professor.getMatricula());
        if(base != null){
            if(base.getMatricula().equals(professor.getMatricula())){
                message.put(HttpStatus.CONFLICT, "Professor já cadastrado!");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
            }
        }

        if(professor.getNome().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Favor preencher o nome do professor!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        professor.setMatricula(service.generateMatricula());
        service.save(professor);
        message.put(HttpStatus.CREATED, "Professor cadastrado com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Professor professor) {
        Map<HttpStatus, String> message = new HashMap<>();
        Professor base = null;

        base = service.findById(professor.getIdProfessor());
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        if(professor.getNome().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Favor preencher o nome do professor!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }

        service.update(professor);
        message.put(HttpStatus.ACCEPTED, "Professor alterado com sucesso!");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") UUID idProfessor) {
        Map<HttpStatus, String> message = new HashMap<>();
        Professor base = null;

        base = service.findById(idProfessor);
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        service.delete(idProfessor);
        message.put(HttpStatus.ACCEPTED, "Professor deletado com sucesso!");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(message);
     }

    @GetMapping("/find/byId/{idProfessor}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idProfessor") UUID idProfessor) {
        Map<HttpStatus, String> message = new HashMap<>();
        Professor base = null;

        base = service.findById(idProfessor);
        if (base == null) {
            message.put(HttpStatus.NOT_FOUND, "Professor não encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        return ResponseEntity.status(HttpStatus.OK).body(base);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Professor>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
