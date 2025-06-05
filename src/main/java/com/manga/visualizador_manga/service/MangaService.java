package com.manga.visualizador_manga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manga.visualizador_manga.model.Manga;
import com.manga.visualizador_manga.repository.MangaRepository;

@Service
public class MangaService {

    @Autowired
    private MangaRepository repository;

    public void createManga(Manga manga){
        repository.save(manga);
    }

    public void deleteManga(Manga manga){
        repository.delete(manga);
    }

    public void deleteByIdManga(Integer id){
        repository.deleteById(id);
    }

    public List<Manga> findAll(){
        return repository.findAll();
    }

    public Manga findByNome(String nome){
        return repository.findByNome(nome);
    }

    public boolean existsByNome(String nome){
        return repository.existsByNome(nome);
    }
}
