package com.example.trello.mapper;

import com.example.trello.dto.permission.PermissionCreateDto;
import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.dto.permission.PermissionUpdateDto;
import com.example.trello.entity.auth.Permission;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<Permission, PermissionDto, PermissionCreateDto, PermissionUpdateDto> {
}
