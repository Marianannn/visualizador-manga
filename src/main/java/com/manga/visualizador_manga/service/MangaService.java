package com.manga.visualizador_manga.service;

import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manga.visualizador_manga.model.Manga;
import com.manga.visualizador_manga.repository.MangaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MangaService {

    @Autowired
    private MangaRepository repository;

    public void createManga(Manga manga) throws AttributeNotFoundException{
        if(manga == null){
            throw new EntityNotFoundException("Manga não pode ser nulo");
        }
        if(manga.getNome() == null || manga.getNome().equals("")){
            throw new AttributeNotFoundException("o atributo nome não pode ser nulo");
        }
        if(manga.getQtdCapitulos() <= 0){
            throw new AttributeNotFoundException("o atributo quantidade de capitulos não pode ser nulo ou menor que zero!!!");
        }
        if(repository.existsByNome(manga.getNome())){
            throw new IllegalArgumentException("este mangá já existe!!!");
        }
        if(manga.getNome().length() > 200){
            throw new IllegalArgumentException("o nome do manga ultrapassa 200 caracteres!!!");
        }
        if(manga.getDescricao().length() > 500){
            throw new IllegalArgumentException("a descrição do manga ultrapassa 500 caracteres!!!");
        }
        repository.save(manga);
    }

    public Manga updateManga(Integer id, Manga mangaAtualizado){
        Manga mangaExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Manga com id " + id + " não encontrado"));
        mangaExistente.setNome(mangaAtualizado.getNome());
        mangaExistente.setFoto(mangaAtualizado.getFoto());
        mangaExistente.setDescricao(mangaAtualizado.getDescricao());
        mangaExistente.setQtdCapitulos(mangaAtualizado.getQtdCapitulos());
        return repository.save(mangaExistente);
    }

    public void deleteManga(Manga manga){
        if(repository.existsByNome(manga.getNome())){
            repository.delete(manga);
        }
    }

    public void deleteById(Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    public List<Manga> findAll(){
        return repository.findAll();
    }

    public Manga findByNome(String nome){
        return repository.findByNome(nome);
    }

    public Optional findById(Integer id){
        return repository.findById(id);
    }

    public boolean existsByNome(String nome){
        return repository.existsByNome(nome);
    }
}
