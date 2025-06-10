package com.manga.visualizador_manga.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "manga")
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mangaId")
    private Integer id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 200, nullable = true)
    private String foto;
    @Column(length = 500, nullable = true)
    private String descricao;
    @Column(nullable = false)
    private int qtdCapitulos;
    
    @Column(length = 200, nullable = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Capitulo> capitulos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdCapitulos() {
        return qtdCapitulos;
    }

    public void setQtdCapitulos(int qtdCapitulos) {
        this.qtdCapitulos = qtdCapitulos;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(List<Capitulo> capitulos) {
        this.capitulos = capitulos;
    }

    @Override
    public String toString(){
        return "\n\nnome: " + this.nome +"\n"+ "foto: " + this.foto + "\n" + "Descrição: " + this.descricao + "\n" + "quantidade de capitulos: " + this.qtdCapitulos + "\n";
    }
}
