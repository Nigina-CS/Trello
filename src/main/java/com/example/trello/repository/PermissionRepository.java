package com.example.trello.repository;

import com.example.trello.entity.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Bakhromjon Thu, 10:15 AM 2/24/2022
 */
public interface PermissionRepository extends JpaRepository<Permission, Long>, AbstractRepository {

    @Query(value = "select * from role_permission where role_id = ?1", nativeQuery = true)
    List<Permission> findByRoleId(Long id);

    @Query(value = "delete from role_repository where permission_id  = ?1", nativeQuery = true)
    void deletePermission(Long id);
}
