package com.example.trello.repository;

import com.example.trello.entity.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<Project, Long>, AbstractRepository {
    @Query(value = "insert into project_column (name,project_id) values (?1,?2)",nativeQuery = true)
    void addProjectColumns(String name,Long id);


    @Query(value = "update Project p set p.archived = true where p.id = :id")
    void archive(@Param("id") Long id);


    @Query(value = "update Project p set p.archived = false where p.id = :id")
    void unarchive(@Param("id") Long id);


    @Query(value = "update Project p set p.closed = true where p.id = :id")
    void close(@Param("id") Long id);
}
