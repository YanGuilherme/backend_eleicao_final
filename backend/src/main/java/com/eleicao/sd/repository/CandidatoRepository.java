package com.eleicao.sd.repository;

import com.eleicao.sd.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    boolean existsByNome(String nome);
    Candidato findByNome(String nome);
}