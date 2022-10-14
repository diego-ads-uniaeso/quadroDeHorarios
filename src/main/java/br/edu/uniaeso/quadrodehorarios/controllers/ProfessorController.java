package br.edu.uniaeso.quadrodehorarios.controllers;


import br.edu.uniaeso.quadrodehorarios.models.Professor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import br.edu.uniaeso.quadrodehorarios.entities.Professor;
import br.edu.uniaeso.quadrodehorarios.services.ProfessorService;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(professor));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(professor));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso!");
    }

    @GetMapping("/find/byId/{idProfessor}")
    public ResponseEntity<Object> findById(@PathVariable(value = "idProfessor") Long codProfessor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(codProfessor));
    }

    @GetMapping("/find/byMatricula/{matricula}")
    public ResponseEntity<Object> findByMatricula(@PathVariable(value = "matricula") String matricula) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByMatricula(matricula));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Professor>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
