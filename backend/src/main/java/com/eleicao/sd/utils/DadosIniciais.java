package com.eleicao.sd.utils;


import com.eleicao.sd.entity.Candidato;
import com.eleicao.sd.repository.CandidatoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
public class DadosIniciais implements CommandLineRunner {

    @Autowired
    private CandidatoRepository candidatoRepository;


    private static final Logger logger = LogManager.getLogger(DadosIniciais.class);

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        logger.info("Criando a base de dados.");
        if (candidatoRepository.count() == 0) {
            candidatoRepository.save(new Candidato("Pedro Damaso", lerImagem("/imagens/votacao/1.png")));
            candidatoRepository.save(new Candidato("Romário", lerImagem("/imagens/votacao/2.png")));
            candidatoRepository.save(new Candidato("Tirica", lerImagem("/imagens/votacao/3.png")));
            candidatoRepository.save(new Candidato("Prefeito de Sorocaba-SP", lerImagem("/imagens/votacao/4.png")));
            candidatoRepository.save(new Candidato("Pastor Mirim", lerImagem("/imagens/votacao/5.png")));
        }

    }

    private byte[] lerImagem(String caminho) throws IOException {
        ClassPathResource imgFile = new ClassPathResource(caminho);
        return imgFile.getInputStream().readAllBytes();
    }
}

