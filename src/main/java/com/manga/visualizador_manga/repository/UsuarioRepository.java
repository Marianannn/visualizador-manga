package com.manga.visualizador_manga.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.manga.visualizador_manga.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    boolean existsByEmail(String email);
}
