package com.example.trello.dto.task;

import com.example.trello.dto.Dto;
import com.example.trello.entity.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TaskCreateDto implements Dto {
    private String name;

    private String priority;

    private String description;

    private boolean closed;

    private LocalDateTime deadLine;

    private String state;

    @ManyToOne
    private Project project;

    @Builder(builderMethodName = "childBuilder")

    public TaskCreateDto(String name, String priority, String description, boolean closed, LocalDateTime deadLine, String state, Project project) {
        this.name = name;
        this.priority = priority;
        this.description = description;
        this.closed = closed;
        this.deadLine = deadLine;
        this.state = state;
        this.project = project;
    }
}

