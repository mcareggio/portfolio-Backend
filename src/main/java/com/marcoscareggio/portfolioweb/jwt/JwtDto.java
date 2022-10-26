package com.marcoscareggio.portfolioweb.jwt;

public class JwtDto {
    private String token;
    private String bearer="Bearer";
    private String nombreusuario;

    public JwtDto(String token, String nombreusuario) {
        this.token = token;
        this.nombreusuario = nombreusuario;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
}
