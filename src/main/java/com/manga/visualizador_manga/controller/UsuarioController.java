package com.manga.visualizador_manga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manga.visualizador_manga.model.Usuario;
import com.manga.visualizador_manga.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService service;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Usuario usuario) {
        service.create(usuario);
        return ResponseEntity.ok("usuario '" + usuario.getNome() + "' foi criado com sucesso!!!");
    }

    @GetMapping
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @PutMapping("{id}")
    public Usuario update(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return service.update(id, usuario);
    }

    @GetMapping("{id}")
    public Usuario findById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.ok("manga com o id '"+ id + "' foi deletado com sucesso!!!");
    }
    
    
    
    


}
