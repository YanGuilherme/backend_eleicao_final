package com.eleicao.sd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Lob
    private byte[] foto;

    public Candidato(String nome, byte[] foto) {
        this.nome = nome;
        this.foto = foto;
    }
}
