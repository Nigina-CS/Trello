package com.example.trello.repository;

import com.example.trello.entity.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Bakhromjon Thu, 10:14 AM 2/24/2022
 */
public interface RoleRepository extends JpaRepository<Role, Long>, AbstractRepository {

    Role findByUserId(Long id);

    @Query(value = "delete from role_permission where role_id = :?;", nativeQuery = true)
    void deleteRole(Long id);
}
