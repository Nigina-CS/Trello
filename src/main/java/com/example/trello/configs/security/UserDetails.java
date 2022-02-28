package com.example.trello.configs.security;

import com.example.trello.entity.auth.AuthUser;
import com.example.trello.entity.auth.Permission;
import com.example.trello.entity.organization.Organization;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails{
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String profile;
    private final boolean active;
    private final boolean blocked;
    private final boolean isSuper;
    private final Organization organization;
    private final boolean admin;

    private List<Permission> permissions;


    public UserDetails(AuthUser user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.profile = user.getProfile();
        this.active = user.isActive();
        this.blocked = user.isBlocked();
        this.isSuper = user.isSuper();
        this.organization = user.getOrganization();
        this.admin = user.isAdmin();
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return permission.stream().map(permission1 -> new SimpleGrantedAuthority(permission1.getCode())).collect(Collectors.toSet());
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return firstName+" "+lastName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !blocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

}
