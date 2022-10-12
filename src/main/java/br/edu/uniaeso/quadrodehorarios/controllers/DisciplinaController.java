package br.edu.uniaeso.quadrodehorarios.controllers;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;
import br.edu.uniaeso.quadrodehorarios.services.DisciplinaService;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<Disciplina> save(@RequestBody Disciplina disciplina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(disciplina));
    }

    @PutMapping("/update")
    public void update(@RequestBody Disciplina disciplina) {
        service.update(disciplina);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping("/find/byCodDisciplina/{codDisciplina}")
    public Disciplina findByCodDisciplina(@PathVariable(value = "codDisciplina") String codDisciplina) {
        return service.findByCodDisciplina(codDisciplina);
    }

    @GetMapping("/find/all")
    public List<Disciplina> listAll() {
        return service.findAll();
    }

}
