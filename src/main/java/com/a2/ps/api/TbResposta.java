package com.a2.ps.api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_respostas")
public class TbResposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Entrevistado tbEntrevistado;

    @Column(name = "resposta", nullable = false, length = Integer.MAX_VALUE)
    private String resposta;

    @Column(name = "id_pergunta", nullable = false)
    private Long idPergunta;

    @Column(name = "id_entrevistado", nullable = false)
    private Long idEntrevistado;

}