package com.cognitive.cogdemver.entities;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN; //да, две роли хуй и когнитивщик

    @Override
    public String getAuthority() {
        return name();
    }
}
