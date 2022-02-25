package com.example.trello.repository;

import com.example.trello.entity.auth.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthUserRepository extends JpaRepository<AuthUser,Long>,AbstractRepository {

    AuthUser findAuthUserByFirstName(String name);

    @Query(value = "select from auth_user where organization_id = ?",nativeQuery = true)
    List<AuthUser> findAllByOrganization_Id(Long id);

    @Query(value = "insert into project_member (user_id,project_id) values (?1, ?2)", nativeQuery = true)
    void addProjectMember(Long userId, Long projectId);
    
    @Query(value = "select user_id from project_member where project_id = ?",nativeQuery = true)
    List<Long>  getProjectMembers(Long projectId);

    @Query(value = "insert into task_member (user_id,task_id) values (?1, ?2)", nativeQuery = true)
    void addTaskMember(Long userId, Long taskId);

    @Query(value = "select user_id from task_member where task_id = ?",nativeQuery = true)
    List<Long>  getTaskMembers(Long taskId);
}
