package com.marcoscareggio.portfolioweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudioscategoria")
public class EstudiosCategoria {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "categoria", nullable = false, length = 45)
    private String categoria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}