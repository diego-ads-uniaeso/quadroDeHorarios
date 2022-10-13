package br.edu.uniaeso.quadrodehorarios.controllers;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;
import br.edu.uniaeso.quadrodehorarios.services.DisciplinaService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(disciplina));
    }

    @PutMapping("/update")
    public ResponseEntity<Object> update(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(disciplina));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada com sucesso!");
    }

    @GetMapping("/find/byCodDisciplina/{codDisciplina}")
    public ResponseEntity<Object> findByCodDisciplina(@PathVariable(value = "codDisciplina") String codDisciplina) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCodDisciplina(codDisciplina));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Disciplina>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
