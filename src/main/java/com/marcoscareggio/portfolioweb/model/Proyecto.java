package com.marcoscareggio.portfolioweb.model;

import javax.persistence.*;

@Entity
@Table(name = "Proyectos")
public class Proyecto {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titulo", nullable = false, length = 45)
    private String titulo;

    @Column(name = "about", length = 45)
    private String about;

    @Column(name = "weblink", length = 45)
    private String weblink;

    @Column(name = "githublink", length = 200)
    private String githublink;

    @Column(name = "devlanguage", nullable = false, length = 45)
    private String devlanguage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getGithublink() {
        return githublink;
    }

    public void setGithublink(String githublink) {
        this.githublink = githublink;
    }

    public String getDevlanguage() {
        return devlanguage;
    }

    public void setDevlanguage(String devlanguage) {
        this.devlanguage = devlanguage;
    }

}