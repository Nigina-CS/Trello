package com.example.trello.repository;

import com.example.trello.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {

    @Query(value = "update comment set context = ?2 where id = ?1", nativeQuery = true)
    void update(Long id, String context);

    @Query(value = "update comment set deleted = true", nativeQuery = true)
    void deleteById(Long id);

    List<Comment> findAllByTask_Id (Long id);
}
