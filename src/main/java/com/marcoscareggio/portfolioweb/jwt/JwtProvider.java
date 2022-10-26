package com.marcoscareggio.portfolioweb.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secret="ymaknsdkksdnckdsnckdncksdnlsldvlsdmvlseyfehuewfhuef74747434dsdfsddsvsslvmsdvmoqnwiUhuewfhuef74747434dsdfsddsvsslvmsdvmoqnwiU";
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(CredentialDto credentialDto){
        return Jwts.builder().setSubject(credentialDto.getNombredeusuario())
        .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .signWith(SignatureAlgorithm.HS512,secret).compact();

    }
    public String getNombreusuario(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody().getSubject();
    }
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJwt(token);
            return true;
        }catch(MalformedJwtException e){e.printStackTrace();
        }catch(UnsupportedJwtException e){e.printStackTrace();
        }catch(ExpiredJwtException e){e.printStackTrace();
        }catch(IllegalArgumentException e){e.printStackTrace();
        }catch(SignatureException e){e.printStackTrace();}
        return false;

    }
}
