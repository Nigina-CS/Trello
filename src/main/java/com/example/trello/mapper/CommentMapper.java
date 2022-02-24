package com.example.trello.mapper;

import com.example.trello.dto.comment.CommentCreateDto;
import com.example.trello.dto.comment.CommentDto;
import com.example.trello.dto.comment.CommentUpdateDto;
import com.example.trello.entity.comment.Comment;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper(componentModel = "spring")
public interface CommentMapper extends BaseMapper<Comment, CommentDto, CommentCreateDto, CommentUpdateDto> {

    @Override
    CommentDto toDto(Comment comment);

    @Override
    List<CommentDto> toDto(List<Comment> e);

    @Override
    Comment fromCreateDto(CommentCreateDto commentCreateDto);

    @Override
    Comment fromUpdateDto(CommentUpdateDto d);
}
