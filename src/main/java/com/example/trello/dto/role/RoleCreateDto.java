package com.example.trello.dto.role;

import com.example.trello.dto.Dto;
import com.example.trello.entity.auth.AuthUser;
import com.example.trello.entity.auth.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
public class RoleCreateDto implements Dto {
    private String code;
    private String name;
    private AuthUser user;
    private List<Permission> permissions;
}
