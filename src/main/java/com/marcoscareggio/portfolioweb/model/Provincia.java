package com.marcoscareggio.portfolioweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "provincia", nullable = false, length = 45)
    private String provincia;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}