package com.marcoscareggio.portfolioweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Acerca_de_mi")
public class AcercaDeMi {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "parrafo", nullable = false)
    private String parrafo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParrafo() {
        return parrafo;
    }

    public void setParrafo(String parrafo) {
        this.parrafo = parrafo;
    }

}