package com.marcoscareggio.portfolioweb.controller;

import com.marcoscareggio.portfolioweb.model.Localidad;
import com.marcoscareggio.portfolioweb.model.Usuario;
import com.marcoscareggio.portfolioweb.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

    @Autowired
    IUsuariosService usrservice;

    @GetMapping("/all")
    @ResponseBody
    public List<Usuario> getAllUsers(){
    return usrservice.get();
    }

    @PostMapping("/create")

    public Usuario createUsuario(@RequestBody Usuario usr){
        usr.setId(null);

        Localidad loc=usr.getLocalidad();
        System.out.println("Saliada"+loc.getId());
        usr=usrservice.save(usr);
        return usr;
    }
}
