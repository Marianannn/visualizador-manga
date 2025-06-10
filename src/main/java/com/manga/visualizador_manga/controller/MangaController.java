package com.manga.visualizador_manga.controller;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manga.visualizador_manga.model.Manga;
import com.manga.visualizador_manga.service.MangaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/manga")
public class MangaController {
    @Autowired
    private MangaService service;

    @PostMapping
    public ResponseEntity<String> createManga(@RequestBody Manga manga) throws AttributeNotFoundException {
        service.createManga(manga);
        return ResponseEntity.ok("deu tudo bao, o manga " + manga.getNome() + " foi criado com sucesso!!!");
    }

    @PutMapping("{id}")
    public Manga updateManga(@PathVariable Integer id, @RequestBody Manga manga) {
               
        return service.updateManga(id, manga);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteManga(@PathVariable Integer id){
        service.deleteById(id);
        return ResponseEntity.ok("manga com o id '" + id + "' foi deletado com sucesso!!!");
    }

    @GetMapping
    public List<Manga> findAllMangas() {
        return service.findAll();
    }

    @GetMapping("/buscar")
    public Manga findMangaByName(@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @GetMapping("/{id}")
    public Optional findMangaById(@PathVariable Integer id){
        return service.findById(id);
    }

    @GetMapping("/exists")
    public ResponseEntity<Boolean> getMethodName(@RequestParam String nome) {
        Boolean exists = service.existsByNome(nome);
        return ResponseEntity.ok(exists);
    }
    
    



    
}
