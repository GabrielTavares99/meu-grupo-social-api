package br.com.api.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_ROLE = "role";
    private static final String CLAIM_KEY_CREATED = "created";

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String getUsernameFromToken(String token) {
        String username;
        Claims claims = getClaimsFromToken(token);
        username = claims.getSubject();
        return username;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        Claims claims = getClaimsFromToken(token);
        expiration = claims.getExpiration();
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;

        claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims;
    }

    public String refreshToken(String token) {
        String refreshedToken;
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        refreshedToken = gerarToken(claims);
        return refreshedToken;
    }

    private String gerarToken(Claims claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(gerarDataExpiracao())
                .signWith(SignatureAlgorithm.ES512, secret)
                .compact();
    }

    public boolean tokenValido(String token) {
        return !tokenExpirado(token);
    }

    public String obterToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
        claims.put(CLAIM_KEY_CREATED, new Date());

        return gerarToken(claims);
    }

    private String gerarToken(Map<String, Object> claims) {
        return null;
    }

    private Date gerarDataExpiracao() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private boolean tokenExpirado(String token) {
        Date dataExpiracao = this.getExpirationDateFromToken(token);
        if (dataExpiracao == null)
            return false;
        return dataExpiracao.before(new Date());
    }


}

