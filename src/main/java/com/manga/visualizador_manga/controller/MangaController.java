package com.manga.visualizador_manga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manga.visualizador_manga.model.Manga;
import com.manga.visualizador_manga.service.MangaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/manga")
public class MangaController {
    @Autowired
    private MangaService service;

    @PostMapping
    public ResponseEntity<String> createManga(@RequestBody Manga manga) {
        service.createManga(manga);
        return ResponseEntity.ok("deu tudo bao, o manga foi criado com sucesso!!!");
    }

    @GetMapping
    public List<Manga> findAllMangas() {
        return service.findAll();
    }

    @GetMapping("/buscar")
    public Manga findMangaByName(@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> getMethodName(@RequestParam String nome) {
        Boolean exists = service.existsByNome(nome);
        return ResponseEntity.ok(exists);
    }
    
    



    
}
