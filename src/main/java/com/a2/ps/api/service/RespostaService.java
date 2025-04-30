package com.a2.ps.api.service;

import com.a2.ps.api.modelo.Entrevistado;
import com.a2.ps.api.modelo.Resposta;
import com.a2.ps.api.modelo.RespostaEntrevistado;
import com.a2.ps.api.repository.EntrevistadoRepository;
import com.a2.ps.api.repository.RespostaEntrevistadoRepository;
import com.a2.ps.api.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;
    @Autowired
    private RespostaEntrevistadoRepository respostaEntrevistadoRepository;
    @Autowired
    private EntrevistadoRepository entrevistadoRepository;

    public List<Resposta> findAll() {
        return respostaRepository.findAll();
    }

    public Optional<Resposta> findById(Long id) {
        return respostaRepository.findById(id);
    }

    public Optional<List<RespostaEntrevistado>> findByEntrevistado(Long idEntrevistado) {
        Entrevistado entrevistado = entrevistadoRepository.findById(idEntrevistado).orElse(null);
        return Optional.ofNullable(respostaEntrevistadoRepository.findByEntrevistado(entrevistado));
    }

    public Resposta save(Resposta resposta) {
        return respostaRepository.save(resposta);
    }

    public void deleteById(Long id) {
        respostaRepository.deleteById(id);
    }
}

