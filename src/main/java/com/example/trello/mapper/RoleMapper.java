package com.example.trello.mapper;

import com.example.trello.dto.role.RoleCreateDto;
import com.example.trello.dto.role.RoleDto;
import com.example.trello.dto.role.RoleUpdateDto;
import com.example.trello.entity.auth.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDto, RoleCreateDto, RoleUpdateDto> {

    @Override
    RoleDto toDto(Role role);

    @Override
    List<RoleDto> toDto(List<Role> e);

    @Override
    Role fromCreateDto(RoleCreateDto roleCreateDto);

    @Override
    Role fromUpdateDto(RoleUpdateDto d);
}
