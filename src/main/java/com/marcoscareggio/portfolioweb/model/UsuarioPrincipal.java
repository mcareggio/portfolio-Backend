package com.marcoscareggio.portfolioweb.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UsuarioPrincipal implements UserDetails {
    private String nombre;
    private String apellido;
    private String nombredeusuario;
    public String email;
    private String password;
    private Localidad localidad;
    private String direccion;
    private String numerocasa;
    private Integer dpto;
    private Integer piso;
    private Collection<? extends GrantedAuthority> authorities;
    public  static UsuarioPrincipal build(Usuario usr){
        return new UsuarioPrincipal(usr);
    }
    UsuarioPrincipal(Usuario usr){
        this.nombre=usr.getNombre();
        this.apellido=usr.getApellido();
        this.nombredeusuario=usr.getNombredeusuario();
        this.email=usr.getEmail();
        this.password=usr.getPassword();
        this.localidad=usr.getLocalidad();
        this.direccion=usr.getDireccion();
        this.numerocasa=usr.getNumerocasa();
        this.dpto=usr.getDpto();
        this.piso=usr.getPiso();
        authorities=null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombredeusuario(String nombredeusuario) {
        this.nombredeusuario = nombredeusuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }

    public void setDpto(Integer dpto) {
        this.dpto = dpto;
    }

    public void setPiso(Integer piso) {
        this.piso = piso;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombredeusuario() {
        return nombredeusuario;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.nombredeusuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNumerocasa() {
        return numerocasa;
    }

    public Integer getDpto() {
        return dpto;
    }

    public Integer getPiso() {
        return piso;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
}
