package com.a2.ps.api.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tb_resposta_entrevistado")
public class RespostaEntrevistado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_entrevistado", nullable = false)
    private Entrevistado entrevistado;

    @ManyToOne
    @JoinColumn(name = "id_resposta", nullable = false)
    private Resposta resposta;

    @Column(name = "data", nullable = false)
    private LocalDate data;

}