package com.a2.ps.api.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_perguntas")
public class Pergunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "pergunta", nullable = false, length = Integer.MAX_VALUE)
    private String pergunta;

    @OneToMany(mappedBy = "resposta")
    private List<Resposta> respostas;

}