package com.a2.ps.api.repository;

import com.a2.ps.api.modelo.Entrevistado;
import com.a2.ps.api.modelo.RespostaEntrevistado;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaEntrevistadoRepository  extends JpaRepository<RespostaEntrevistado, Long> {


   public RespostaEntrevistado findByEntrevistado(Entrevistado entrevistado);
}
