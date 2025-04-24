package com.a2.ps.api.service;

import com.a2.ps.api.modelo.Entrevistado;
import com.a2.ps.api.repository.EntrevistadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrevistadoService {

    @Autowired
    private EntrevistadoRepository entrevistadoRepository;

    public List<Entrevistado> findAll() {
        return entrevistadoRepository.findAll();
    }

    public Optional<Entrevistado> findById(Long id) {
        return entrevistadoRepository.findById(id);
    }

    public Entrevistado save(Entrevistado entrevistado) {
        return entrevistadoRepository.save(entrevistado);
    }

    public void deleteById(Long id) {
        entrevistadoRepository.deleteById(id);
    }
}

