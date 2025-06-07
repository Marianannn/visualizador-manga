package com.manga.visualizador_manga.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.manga.visualizador_manga.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    @Query("SELECT u FROM Usuario u WHERE u.id = :id")
        Optional<Usuario> findById(@Param("id") Integer id);

        boolean existsByNome(String nome);
}
