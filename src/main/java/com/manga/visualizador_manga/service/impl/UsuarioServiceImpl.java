package com.manga.visualizador_manga.service.impl;

import java.util.List;

// import javax.management.AttributeNotFoundException; // Removed because we will use IllegalArgumentException

import org.springframework.stereotype.Service;
import com.manga.visualizador_manga.model.Usuario;
import com.manga.visualizador_manga.repository.UsuarioRepository;
import com.manga.visualizador_manga.service.UsuarioService;
import com.manga.visualizador_manga.service.exception.NotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(Integer id){
        return repository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public Usuario create(Usuario usuario){
        
        if(usuario.getNome() == null || usuario.getNome().isEmpty()){
            throw new IllegalArgumentException("Nome do usuário não pode ser nulo!!!");
        }
        if(usuario.getEmail() == null || usuario.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email do usuário não pode ser nulo!!!");
        }
        if(usuario.getSenha() == null || usuario.getSenha().isEmpty()){
            throw new IllegalArgumentException("Senha não pode ser nula!!!");
        }

        if(repository.existsByEmail(usuario.getEmail())){
            
            throw new IllegalArgumentException("Email já cadastrado!");
        }
        return repository.save(usuario);
    }

    public Usuario update(Integer id, Usuario usuario){
        Usuario usuarioBanco = this.findById(id);
        if(!usuarioBanco.getId().equals(usuarioBanco.getId())){
            throw new IllegalArgumentException("id de atualização precisa ser o mesmo.");
        }

        usuarioBanco.setNome(usuario.getNome());
        usuarioBanco.setEmail(usuario.getEmail());
        usuarioBanco.setSenha(usuario.getSenha());
        return repository.save(usuarioBanco);
    }

    public void delete(Integer id){
        Usuario usuarioBanco = this.findById(id);
        this.repository.delete(usuarioBanco);
    }

    public Boolean existsByEmail(String email){
        Boolean exists = repository.existsByEmail(email);
        return exists;
    }
    
}
