package com.manga.visualizador_manga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manga.visualizador_manga.model.Manga;

public interface MangaRepository extends JpaRepository<Manga, Integer>{

        @Query("SELECT m FROM Manga m WHERE m.nome = :nome")
        Manga findByNome(@Param("nome") String nome);
        // é bom tomar cuidado com o nome das funções que se dá aqui, mais porque pode dar b.o antes eu tinha colocado dinfbymanganame e ele nao tava reconhendo


        boolean existsByNome(String nome);

}
