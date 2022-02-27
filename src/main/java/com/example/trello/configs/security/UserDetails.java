package com.example.trello.configs.security;

import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.entity.auth.AuthUser;
import com.example.trello.entity.auth.Permission;
import com.example.trello.services.auth.AuthUserService;
import com.example.trello.services.permission.PermissionService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails{

    private PermissionService service;

    private AuthUser user;
    private Long id;

    public UserDetails(AuthUser user) {
        this.user = user;
        this.id = user.getId();
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = new HashSet<>();

        List<PermissionDto> permissions = service.getPermissionByUserId(id);

        if (Objects.isNull(permissions)) {
            return authorities;
        }

        authorities.addAll(
                permissions.stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getCode()))
                        .collect(Collectors.toSet())
        );
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getFirstName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.isBlocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }
}
