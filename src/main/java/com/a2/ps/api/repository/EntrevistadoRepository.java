package com.a2.ps.api.repository;

import com.a2.ps.api.modelo.Entrevistado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrevistadoRepository extends JpaRepository<Entrevistado, Long> {


}

