package com.example.trello.services.comment;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.comment.CommentCreateDto;
import com.example.trello.dto.comment.CommentDto;
import com.example.trello.dto.comment.CommentUpdateDto;
import com.example.trello.entity.comment.Comment;
import com.example.trello.services.BaseService;
import com.example.trello.services.GenericCrudService;


public interface CommentService extends GenericCrudService<
        Comment,
        CommentDto,
        CommentCreateDto,
        CommentUpdateDto,
        GenericCriteria,
        Long>, BaseService {

}
