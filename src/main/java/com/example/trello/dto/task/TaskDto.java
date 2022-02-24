package com.example.trello.dto.task;

import com.example.trello.dto.GenericDto;
import com.example.trello.entity.auth.AuthUser;
import com.example.trello.entity.comment.Comment;
import com.example.trello.entity.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
public class TaskDto extends GenericDto {
    private String name;

    private String priority;

    private String description;

    private boolean closed;

    private String state;

    private LocalDateTime deadLine;

    private List<AuthUser> users;

    private Project project;

    private List<Comment> comments;

    @Builder(builderMethodName = "childMethod")

    public TaskDto(Long id, String name, String priority, String description, boolean closed, String state, LocalDateTime deadLine, List<AuthUser> users, Project project, List<Comment> comments) {
        super(id);
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.closed = closed;
        this.state = state;
        this.deadLine = deadLine;
        this.users = users;
        this.project = project;
        this.comments = comments;
    }
}
