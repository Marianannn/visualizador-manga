package com.manga.visualizador_manga.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pagina")
public class Pagina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paginaId")
    private Integer id;
    @Column(length = 200, nullable = false)
    private String img;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
}
