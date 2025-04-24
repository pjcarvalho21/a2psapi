package com.a2.ps.api.controller;

import com.a2.ps.api.modelo.Pergunta;
import com.a2.ps.api.service.PerguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/perguntas", produces = MediaType.APPLICATION_JSON_VALUE)
public class PerguntaController {

    @Autowired
    private PerguntaService perguntaService;

    @GetMapping
    public List<Pergunta> getAll() {
        return perguntaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pergunta> getById(@PathVariable Long id) {
        Optional<Pergunta> pergunta = perguntaService.findById(id);
        return pergunta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pergunta> create(@RequestBody Pergunta pergunta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perguntaService.save(pergunta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pergunta> update(@PathVariable Long id, @RequestBody Pergunta pergunta) {
        if (perguntaService.findById(id).isPresent()) {
            pergunta.setId(id);
            return ResponseEntity.ok(perguntaService.save(pergunta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (perguntaService.findById(id).isPresent()) {
            perguntaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

