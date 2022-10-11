package br.edu.uniaeso.quadrodehorarios.controllers;

import br.edu.uniaeso.quadrodehorarios.entities.Disciplina;
import br.edu.uniaeso.quadrodehorarios.services.DisciplinaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/disciplina")
public class CDisciplina {

    @Autowired
    private DisciplinaService service;

    @PostMapping("/save")
    public Disciplina save(@RequestBody Disciplina disciplina) {
        return service.save(disciplina);
    }

    @PutMapping("/update")
    public void update(@RequestBody Disciplina disciplina) {
        service.update(disciplina);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }

    @GetMapping("/find/{codDisciplina}")
    public Disciplina findByCodDisciplina(@PathVariable(value = "codDisciplina") String codDisciplina) {
        return service.findByCodDisciplina(codDisciplina);
    }

    @GetMapping("/find/all")
    public List<Disciplina> listAll() {
        return service.findAll();
    }

}
