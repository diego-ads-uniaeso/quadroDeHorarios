package br.edu.uniaeso.quadrodehorarios.controllers;

import br.edu.uniaeso.quadrodehorarios.models.Disciplina;
import br.edu.uniaeso.quadrodehorarios.services.DisciplinaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaService service;

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Disciplina disciplina) {
        Map<HttpStatus, String> message = new HashMap<>();
        if(service.findByCodDisciplina(disciplina.getCodDisciplina()) != null) {
            message.put(HttpStatus.CONFLICT, "Código da disciplina já existente!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if(service.findByNome(disciplina.getNome()) != null) {
            message.put(HttpStatus.CONFLICT, "Nome da disciplina já existente!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if(service.save(disciplina) != null) {
            message.put(HttpStatus.CREATED, "Disciplina cadastrada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
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
