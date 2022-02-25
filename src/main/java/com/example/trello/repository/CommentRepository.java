package com.example.trello.repository;

import com.example.trello.entity.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>, AbstractRepository {

    List<Comment> findAllByTask_Id (Long id);
}
