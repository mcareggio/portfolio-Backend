package com.marcoscareggio.portfolioweb.repository;

import com.marcoscareggio.portfolioweb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
