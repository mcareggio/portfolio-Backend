package com.marcoscareggio.portfolioweb.model;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "localidad_id", nullable = false, referencedColumnName = "id")
    private Localidad localidad;
    //private Integer localidad_id;
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    /*
    @Column(name = "localidad_id", nullable = false)
    private Integer localidad_id;
    */
    @Column(name = "apellido", nullable = false, length = 45)
    private String apellido;

    @Column(name = "nombredeusuario", nullable = false, length = 45)
    private String nombredeusuario;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "numerocasa", length = 45)
    private String numerocasa;

    @Column(name = "dpto")
    private Integer dpto;

    @Column(name = "piso")
    private Integer piso;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
/*
    public Integer getLocalidad_id() {
        return localidad_id;
    }

    public void setLocalidad_id(Integer localidad_id) {
        this.localidad_id = localidad_id;
    }
*/
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombredeusuario() {
        return nombredeusuario;
    }

    public void setNombredeusuario(String nombredeusuario) {
        this.nombredeusuario = nombredeusuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }

    public Integer getDpto() {
        return dpto;
    }

    public void setDpto(Integer dpto) {
        this.dpto = dpto;
    }

    public Integer getPiso() {
        return piso;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

}