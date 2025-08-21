package com.chatapplication.chatapplication.security.internals;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

public class CustomJwtAuthenticationToken extends JwtAuthenticationToken {

    private final String sub;

    public CustomJwtAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, String sub) {
        super(jwt, authorities);
        this.sub = sub;
    }

    @Override
    public Object getPrincipal() {
        return sub;
    }

}
