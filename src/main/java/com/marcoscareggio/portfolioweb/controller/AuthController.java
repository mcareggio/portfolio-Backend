package com.marcoscareggio.portfolioweb.controller;

import com.marcoscareggio.portfolioweb.jwt.JwtDto;
import com.marcoscareggio.portfolioweb.jwt.JwtProvider;
import com.marcoscareggio.portfolioweb.jwt.CredentialDto;
import com.marcoscareggio.portfolioweb.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passencoder;
    @Autowired
    AuthenticationManager authmanager;
    @Autowired
    UsuariosService usrservice;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CredentialDto credentialDto, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Mensaje("Tiene errores"), HttpStatus.BAD_REQUEST);
        Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(credentialDto.getNombredeusuario(), credentialDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        //diferente cambia credential por authentication
        String jwttoken=jwtProvider.generateToken(credentialDto);
        UserDetails usrdetail=(UserDetails) auth.getPrincipal();
        JwtDto jwtdto=new JwtDto(jwttoken,usrdetail.getUsername());

        return new ResponseEntity(jwtdto,HttpStatus.OK);

    }
}
