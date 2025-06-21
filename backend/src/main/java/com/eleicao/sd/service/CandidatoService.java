package com.eleicao.sd.service;

import com.eleicao.sd.entity.Candidato;
import com.eleicao.sd.repository.CandidatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;

    public List<Candidato> listAll(){
        return candidatoRepository.findAll();
    }

    public Candidato findById(Long id) {
        return candidatoRepository.findById(id).orElseThrow();
    }

}
