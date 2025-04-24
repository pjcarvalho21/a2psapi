package com.a2.ps.api;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_perguntas")
public class TbPergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pergunta", nullable = false, length = Integer.MAX_VALUE)
    private String pergunta;

    @OneToOne(mappedBy = "id")
    private com.a2.ps.api.TbResposta tbResposta;

}