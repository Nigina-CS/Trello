package com.example.trello.repository;

import com.example.trello.entity.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long>, AbstractRepository{

    @Query(value = "from Task where project = :id")
    List<Task> findAllByProject_Id(@Param("id") Long id);
}

