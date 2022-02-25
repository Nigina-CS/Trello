package com.example.trello.services.role;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.role.RoleCreateDto;
import com.example.trello.dto.role.RoleDto;
import com.example.trello.dto.role.RoleUpdateDto;
import com.example.trello.entity.auth.Role;
import com.example.trello.exception.NotFoundException;
import com.example.trello.mapper.RoleMapper;
import com.example.trello.repository.PermissionRepository;
import com.example.trello.repository.RoleRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.auth.RoleValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class RoleServiceImpl extends AbstractService<
        RoleRepository,
        RoleMapper,
        RoleValidator>
        implements RoleService {

    private final PermissionRepository permissionRepository;

    public RoleServiceImpl(RoleRepository repository, RoleMapper mapper, RoleValidator validator, PermissionRepository permissionRepository) {
        super(repository, mapper, validator);
        this.permissionRepository = permissionRepository;
    }

    @Override
    public Long create(RoleCreateDto createDto) {
        Role role = mapper.fromCreateDto(createDto);
        repository.save(role);
        return role.getId();
    }

    @Transactional
    @Override
    public Void update(RoleUpdateDto updateDto) {
        Role role = repository.findById(updateDto.getId()).orElseThrow(() -> new NotFoundException("Role Not Found"));
        delete(role.getId());
        role.setPermissions(updateDto.getPermissions());
        repository.save(role);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteRole(id);
        return null;
    }

    @Override
    public List<RoleDto> getAll(GenericCriteria criteria) {
        List<Role> all = repository.findAll();
        return mapper.toDto(all);
    }

    @Override
    public RoleDto get(Long id) {
        Role role = repository.findByUserId(id);
        return mapper.toDto(role);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

}
