package com.marcoscareggio.portfolioweb.jwt;

import com.marcoscareggio.portfolioweb.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    JwtProvider jwtprov;
    @Autowired
    UserDetailService usrdetserv;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
        String token=getToken(request);
        if(token!=null&&jwtprov.validateToken(token)){
            String nombredeusuario=jwtprov.getNombreusuario(token);
            UserDetails userDetails=usrdetserv.loadUserByUsername(nombredeusuario);
            UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        }catch(Exception e){e.printStackTrace();System.out.println("Fallo el doFilterInternal de JwtTokenFIlter");}
        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest req){
        String header=req.getHeader("Authorization");
        if(header!=null&&header.startsWith("Bearer")){
            return header.replace("Bearer","");
        }
        return null;

    }
}
