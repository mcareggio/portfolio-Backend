package com.marcoscareggio.portfolioweb.repository;

import com.marcoscareggio.portfolioweb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    public List<Usuario> findBynombredeusuario(String nombredeusuario);
    //no anda esto public boolean existnombredeusuario(String nombredeusuario);
}
