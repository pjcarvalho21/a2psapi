package com.a2.ps.api.service;

import com.a2.ps.api.modelo.Resposta;
import com.a2.ps.api.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    public List<Resposta> findAll() {
        return respostaRepository.findAll();
    }

    public Optional<Resposta> findById(Long id) {
        return respostaRepository.findById(id);
    }

    public Resposta save(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public void deleteById(Long id) {
        respostaRepository.deleteById(id);
    }
}

