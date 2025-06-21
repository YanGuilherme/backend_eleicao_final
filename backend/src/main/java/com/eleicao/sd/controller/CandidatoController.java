package com.eleicao.sd.controller;

import com.eleicao.sd.entity.Candidato;
import com.eleicao.sd.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @GetMapping("/candidatos")
    public ResponseEntity<List<Candidato>> findAll(){
        List<Candidato> list = candidatoService.listAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/candidatos/{id}/imagem")
    public ResponseEntity<byte[]> buscarImagem(@PathVariable Long id) {
        Candidato candidato = candidatoService.findById(id);
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG) // ou IMAGE_PNG dependendo da imagem
                .body(candidato.getFoto());
    }
}
