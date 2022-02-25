package com.example.trello.services.permission;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.permission.PermissionCreateDto;
import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.dto.permission.PermissionUpdateDto;
import com.example.trello.entity.auth.Permission;
import com.example.trello.services.BaseService;
import com.example.trello.services.GenericCrudService;

import java.util.List;


public interface PermissionService extends GenericCrudService<
        Permission,
        PermissionDto,
        PermissionCreateDto,
        PermissionUpdateDto,
        GenericCriteria,
        Long>, BaseService {
    List<PermissionDto> getAllByUserId(Long id);

}
