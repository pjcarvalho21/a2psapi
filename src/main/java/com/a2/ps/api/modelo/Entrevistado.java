package com.a2.ps.api.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_entrevistado")
public class Entrevistado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = Integer.MAX_VALUE)
    private String nome;


    @OneToMany(mappedBy = "entrevistado")
    private List<Resposta> respostas;

}