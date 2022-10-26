package com.marcoscareggio.portfolioweb.service;

import com.marcoscareggio.portfolioweb.model.Usuario;
import com.marcoscareggio.portfolioweb.model.UsuarioPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UsuariosService usuariosService;

    @Override
    public UserDetails loadUserByUsername(String nombredeusuario)throws UsernameNotFoundException {
        Usuario usr=usuariosService.findByUsername(nombredeusuario).get(0);
        return UsuarioPrincipal.build(usr);

    }

}
