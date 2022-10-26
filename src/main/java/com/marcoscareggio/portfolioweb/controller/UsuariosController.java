package com.marcoscareggio.portfolioweb.controller;

import com.marcoscareggio.portfolioweb.jwt.JwtProvider;
import com.marcoscareggio.portfolioweb.jwt.CredentialDto;
import com.marcoscareggio.portfolioweb.model.Localidad;
import com.marcoscareggio.portfolioweb.model.Usuario;
import com.marcoscareggio.portfolioweb.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin
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
        System.out.println("Salida"+loc.getId());
        usr=usrservice.save(usr);
        return usr;
    }
    @PostMapping("/auth")
    @ResponseBody
    public Usuario autenticarUsuario(@RequestBody CredentialDto credentialDto) {
        Usuario usr=null;
        boolean verficarPassword=true;

        try {
            usr = usrservice.findByUsername(credentialDto.getNombredeusuario()).get(0);
            JwtProvider jwtprov=new JwtProvider();
            System.out.println(jwtprov.generateToken(credentialDto));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("El usuario no existe");
            verficarPassword=false;}

        return verficarPassword ? (credentialDto.isValidPassword(usr) ? usr : null):null;
    }
}
