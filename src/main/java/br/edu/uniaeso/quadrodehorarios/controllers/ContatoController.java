package br.edu.uniaeso.quadrodehorarios.controllers;

import br.edu.uniaeso.quadrodehorarios.models.Contato;
import br.edu.uniaeso.quadrodehorarios.services.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/quadrodehorarios/contato")
public class ContatoController {

    @Autowired
    ContatoService service;
    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Contato contato) {
        Map<HttpStatus, String> message = new HashMap<>();
        if(contato.getNome().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Por favor, informe o nome!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if(contato.getConteudo().isEmpty()) {
            message.put(HttpStatus.CONFLICT, "Por favor, informe o conteúdo desejado!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        if(!contato.getElogio() && !contato.getReclamacao()) {
            message.put(HttpStatus.CONFLICT, "Selecione uma opção!");
            return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
        }
        service.save(contato);
        if(contato.getElogio()) {
            message.put(HttpStatus.CREATED, "Elogio cadastrado com sucesso!");
        } else {
            message.put(HttpStatus.CREATED, "Reclamação cadastrada com sucesso!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
