package com.a2.ps.api.controller;

import com.a2.ps.api.modelo.Resposta;
import com.a2.ps.api.modelo.RespostaEntrevistado;
import com.a2.ps.api.service.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/respostas", produces = MediaType.APPLICATION_JSON_VALUE)
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @GetMapping
    public List<Resposta> getAll() {
        return respostaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resposta> getById(@PathVariable Long id) {
        Optional<Resposta> resposta = respostaService.findById(id);
        return resposta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/entrevistado/{id}")
    public ResponseEntity<List<RespostaEntrevistado>> getByEntrevistado(@PathVariable Long id) {
        Optional<List<RespostaEntrevistado>> resposta = respostaService.findByEntrevistado(id);
        return resposta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resposta> create(@RequestBody Resposta resposta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(respostaService.save(resposta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta> update(@PathVariable Long id, @RequestBody Resposta resposta) {
        if (respostaService.findById(id).isPresent()) {
            resposta.setId(id);
            return ResponseEntity.ok(respostaService.save(resposta));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (respostaService.findById(id).isPresent()) {
            respostaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

