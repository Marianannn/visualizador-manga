package com.manga.visualizador_manga.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Capitulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "capituloId")
    private Integer id;

    @Column(length = 200, nullable = false)
    private int numeroCapitulo;
    @Column(length = 200, nullable = false)
    private int qtdpaginas;
    @Column(length = 200, nullable = true)
    private List<Pagina> paginas;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroCapitulo() {
        return numeroCapitulo;
    }
    public void setNumeroCapitulo(int numeroCapitulo) {
        this.numeroCapitulo = numeroCapitulo;
    }
    public int getQtdpaginas() {
        return qtdpaginas;
    }
    public void setQtdpaginas(int qtdpaginas) {
        this.qtdpaginas = qtdpaginas;
    }
    public List<Pagina> getPaginas() {
        return paginas;
    }
    public void setPaginas(List<Pagina> paginas) {
        this.paginas = paginas;
    }

}
