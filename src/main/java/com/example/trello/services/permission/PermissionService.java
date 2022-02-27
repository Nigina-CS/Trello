package com.example.trello.services.permission;

import com.example.trello.dto.permission.PermissionDto;
import com.example.trello.entity.auth.Permission;
import com.example.trello.mapper.PermissionMapper;
import com.example.trello.repository.PermissionRepository;
import com.example.trello.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermissionService implements BaseService {
    private final PermissionRepository repository;
    private final PermissionMapper mapper;

    public PermissionService(PermissionRepository repository, PermissionMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public Void addPermission(List<Long> permissionId, Long userId) {
        for (Long id : permissionId) {
            repository.addPermission(id,userId);
        }
        return null;
    }

    public List<PermissionDto> getPermissions() {
        List<Permission> permissions = repository.findAll();
        return mapper.toDto(permissions);
    }

    public List<PermissionDto> getPermissionByUserId(Long userId) {
        List<Long> permissionId = repository.getPermissionByUserId(userId);
        List<Optional<Permission>> permissions = null;
        for (Long id : permissionId) {
            permissions.add(repository.findById(id));
        }
        List<Permission> permissionList = permissions.stream().flatMap(Optional::stream).toList();
        return mapper.toDto(permissionList);
    }

    public Void revokePermission(List<Long> permissionId,Long userId) {
        for (Long id : permissionId) {
            repository.revokePermission(id,userId);
        }
        return null;
    }
}

