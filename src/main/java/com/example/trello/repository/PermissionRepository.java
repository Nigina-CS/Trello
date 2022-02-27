package com.example.trello.repository;

import com.example.trello.entity.auth.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PermissionRepository extends JpaRepository<Permission, Long>, AbstractRepository {

    @Query(value = "insert into auth_permission (permission_id,user_id) values(?1,?2)",nativeQuery = true)
    Void addPermission(Long permissionId,Long userId);

    @Query(value = "select permission_id from auth_permission where user_id = ?",nativeQuery = true)
    List<Long> getPermissionByUserId(Long id);

    @Query(value = "delete from auth_permission where permisson_id =?1 and user_id =?2",nativeQuery = true)
    Void revokePermission(Long permissionId, Long userId);
}
