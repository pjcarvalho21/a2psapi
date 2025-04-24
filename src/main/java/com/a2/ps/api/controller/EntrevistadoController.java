package com.a2.ps.api.controller;

import com.a2.ps.api.modelo.Entrevistado;
import com.a2.ps.api.service.EntrevistadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/entrevistados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EntrevistadoController {

    @Autowired
    private EntrevistadoService entrevistadoService;

    @GetMapping
    public List<Entrevistado> getAll() {
        return entrevistadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrevistado> getById(@PathVariable Long id) {
        Optional<Entrevistado> entrevistado = entrevistadoService.findById(id);
        return entrevistado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Entrevistado> create(@RequestBody Entrevistado entrevistado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(entrevistadoService.save(entrevistado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entrevistado> update(@PathVariable Long id, @RequestBody Entrevistado entrevistado) {
        if (entrevistadoService.findById(id).isPresent()) {
            entrevistado.setId(id);
            return ResponseEntity.ok(entrevistadoService.save(entrevistado));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (entrevistadoService.findById(id).isPresent()) {
            entrevistadoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

