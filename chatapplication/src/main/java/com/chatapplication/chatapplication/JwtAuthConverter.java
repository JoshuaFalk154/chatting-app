package com.chatapplication.chatapplication;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class JwtAuthConverter implements Converter<Jwt, JwtAuthenticationToken> {

    // TODO
    // create user if not existing

    private final JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();

    @Override
    public JwtAuthenticationToken convert(Jwt source) {
        String sub = source.getClaim("sub");

        List<GrantedAuthority> auths = Stream.concat(extractRoles(source).stream(),
                        jwtGrantedAuthoritiesConverter.convert(source).stream())
                .toList();

        return new CustomJwtAuthenticationToken(source, auths, sub);
    }

    public Collection<? extends GrantedAuthority> extractRoles(Jwt jwt) {

        try {
            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");
            if (resourceAccess == null) {
                return new ArrayList<>();
            }

            Map<String, Object> frontend = (Map<String, Object>) (resourceAccess.get("frontend"));
            if (frontend == null) {
                return new ArrayList<>();
            }

            List<String> roles = (List<String>) (frontend.get("roles"));
            if (roles == null) {
                return new ArrayList<>();
            }

            return roles.stream()
                    .map(string -> new SimpleGrantedAuthority("ROLES" + string.toUpperCase()))
                    .collect(Collectors.toList());

        } catch (ClassCastException e) {
            return new ArrayList<>();
        }
    }


}
