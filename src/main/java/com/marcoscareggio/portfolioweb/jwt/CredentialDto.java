package com.marcoscareggio.portfolioweb.jwt;

import com.marcoscareggio.portfolioweb.model.Usuario;

public class CredentialDto {
    
    private String nombredeusuario;
    private String password;

    public CredentialDto(String nombredeusuario, String password) {
        this.nombredeusuario = nombredeusuario;
        this.password = password;
    }

    public String getNombredeusuario() {
        return nombredeusuario;
    }

    public String getPassword() {
        return password;
    }

    public void setNombredeusuario(String nombredeusuario) {
        this.nombredeusuario = nombredeusuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isValidPassword(Usuario usr){
        return usr.getPassword().compareTo(this.password)==0;
    }
}
