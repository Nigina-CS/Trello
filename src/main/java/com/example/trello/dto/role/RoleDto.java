package com.example.trello.dto.role;

import com.example.trello.dto.GenericDto;
import com.example.trello.entity.auth.AuthUser;
import com.example.trello.entity.auth.Permission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
public class RoleDto extends GenericDto {
    private String code;
    private String name;
    private AuthUser user;
    private List<Permission> permissions;


    @Builder(builderMethodName = "childBuilder")
    public RoleDto(Long id, String code, String name, AuthUser user, List<Permission> permissions) {
        super(id);
        this.code = code;
        this.name = name;
        this.user = user;
        this.permissions = permissions;
    }
}
