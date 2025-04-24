package com.a2.ps.api.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_respostas")
public class Resposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "resposta", nullable = false, length = Integer.MAX_VALUE)
    private String resposta;

    @ManyToOne
    @JoinColumn(name = "idPergunta")
    private Pergunta pergunta;

    @ManyToOne
    @JoinColumn(name = "id_entrevistado")
    private Entrevistado entrevistado;


}