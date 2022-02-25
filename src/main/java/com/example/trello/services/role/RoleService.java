package com.example.trello.services.role;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.role.RoleCreateDto;
import com.example.trello.dto.role.RoleDto;
import com.example.trello.dto.role.RoleUpdateDto;
import com.example.trello.entity.auth.Role;
import com.example.trello.services.BaseService;
import com.example.trello.services.GenericCrudService;


public interface RoleService extends GenericCrudService<
        Role,
        RoleDto,
        RoleCreateDto,
        RoleUpdateDto,
        GenericCriteria,
        Long>, BaseService {

}
