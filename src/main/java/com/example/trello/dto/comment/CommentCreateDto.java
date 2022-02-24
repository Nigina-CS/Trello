package com.example.trello.dto.comment;

import com.example.trello.dto.Dto;
import com.example.trello.entity.task.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDto implements Dto {
    private String context;
    private Task task;
}
