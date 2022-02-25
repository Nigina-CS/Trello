package com.example.trello.dto.role;

import com.example.trello.dto.GenericDto;
import com.example.trello.entity.auth.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
public class RoleUpdateDto extends GenericDto {
    private List<Permission> permissions;
}
