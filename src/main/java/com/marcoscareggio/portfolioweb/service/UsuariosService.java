package com.marcoscareggio.portfolioweb.service;

import com.marcoscareggio.portfolioweb.model.Usuario;
import com.marcoscareggio.portfolioweb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    UsuarioRepository usuariorep;

    @Override
    public List<Usuario> get() {
        return usuariorep.findAll();

    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuariorep.save(usuario);
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void find(Integer id) {

    }

    @Override
    public List<Usuario> findByUsername(String username) {
        return usuariorep.findBynombredeusuario(username);
    }
}
