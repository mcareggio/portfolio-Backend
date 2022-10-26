package com.marcoscareggio.portfolioweb.service;

import com.marcoscareggio.portfolioweb.model.Usuario;

import java.util.List;

public interface IUsuariosService extends ICommonService<Usuario,Integer>{
    public List<Usuario> findByUsername(String username);
}
