package com.example.trello.configs.security;

import com.example.trello.entity.auth.AuthUser;
import com.example.trello.repository.AuthUserRepository;
import com.example.trello.repository.PermissionRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private final AuthUserRepository authUserRepository;
    private final PermissionRepository permissionRepository;

    public ApplicationUserDetailsService(AuthUserRepository authUserRepository,  PermissionRepository permissionRepository) {
        this.authUserRepository = authUserRepository;
        this.permissionRepository = permissionRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser user = authUserRepository.findAuthUserByEmail(username);

        if (user == null) throw new UsernameNotFoundException("User was not found");



        return new UserDetails(user);
    }
}
