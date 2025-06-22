package com.eleicao.sd.controller;

import com.eleicao.sd.entity.Candidato;
import com.eleicao.sd.service.CandidatoService;
import com.eleicao.sd.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/candidatos")
    public ResponseEntity<List<Candidato>> findAll(@RequestHeader("Authorization") String token){
        try{
            String cleanToken = token.replace("Bearer ", "");
            if (!jwtUtil.validateToken(cleanToken)) {
                return ResponseEntity.status(401).build();
            }
            List<Candidato> list = candidatoService.listAll();
            return ResponseEntity.ok(list);
        }catch (Exception e){
            return ResponseEntity.status(400).build();
        }
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
