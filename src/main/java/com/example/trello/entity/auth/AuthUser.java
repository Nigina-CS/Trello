package com.example.trello.entity.auth;

import com.example.trello.entity.Auditable;
import com.example.trello.entity.organization.Organization;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthUser extends Auditable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profile;
    private boolean active;
    private boolean blocked;
    private boolean isAdmin;
    private boolean isSuper;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "auth_permission",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id")
    )
    private List<Permission> permissions;

    @ManyToOne
    private Organization organization;



}
