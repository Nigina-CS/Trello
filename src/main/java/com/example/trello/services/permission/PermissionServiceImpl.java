package com.example.trello.services.permission;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.permission.PermissionCreateDto;
import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.dto.permission.PermissionUpdateDto;
import com.example.trello.entity.auth.Permission;
import com.example.trello.entity.auth.Role;
import com.example.trello.mapper.PermissionMapper;
import com.example.trello.repository.PermissionRepository;
import com.example.trello.repository.RoleRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.auth.PermissionValidator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissionServiceImpl extends AbstractService<
        PermissionRepository,
        PermissionMapper,
        PermissionValidator>
        implements PermissionService {

    private final RoleRepository roleRepository;

    public PermissionServiceImpl(PermissionRepository repository, PermissionMapper mapper, PermissionValidator validator, RoleRepository roleRepository) {
        super(repository, mapper, validator);
        this.roleRepository = roleRepository;
    }

    @Override
    public Long create(PermissionCreateDto createDto) {
        Permission permission = mapper.fromCreateDto(createDto);
        repository.save(permission);
        return permission.getId();
    }

    // NO UPDATE
    @Override
    public Void update(PermissionUpdateDto updateDto) {
        return null;
    }

    // TODO: 2/24/2022 delete
    @Override
    public Void delete(Long id) {
        repository.deletePermission(id);
        return null;
    }

    @Override
    public List<PermissionDto> getAll(GenericCriteria criteria) {
        List<Permission> all = repository.findAll();
        return mapper.toDto(all);
    }

    // NO GET
    @Override
    public PermissionDto get(Long id) {
        return null;
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    public List<PermissionDto> getAllRoleById(Long id) {
        List<Permission> permissions = repository.findByRoleId(id);
        return mapper.toDto(permissions);
    }

    @Override
    public List<PermissionDto> getAllByUserId(Long id) {
        Role role = roleRepository.findByUserId(id);
        return getAllRoleById(role.getId());
    }
}
