package com.marcoscareggio.portfolioweb.model;

import javax.persistence.*;

@Entity
@Table(name = "Proyectos_img")
public class ProyectosImg {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId("proyectosId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Proyectos_id", nullable = false, referencedColumnName = "id")
    private Proyecto proyectos;

    @Column(name = "link", nullable = false, length = 200)
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Proyecto getProyectos() {
        return proyectos;
    }

    public void setProyectos(Proyecto proyectos) {
        this.proyectos = proyectos;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}