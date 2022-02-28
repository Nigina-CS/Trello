package com.example.trello.configs.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class SessionUser {

    public static UserDetails session() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static Long sessionId() {
        return session().getId();
    }

}
