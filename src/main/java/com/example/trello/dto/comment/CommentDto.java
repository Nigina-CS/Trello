package com.example.trello.dto.comment;

import com.example.trello.dto.GenericDto;
import com.example.trello.entity.task.Task;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
public class CommentDto extends GenericDto {
    private String context;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private Long taskId;


    @Builder(builderMethodName = "childBuilder")
    public CommentDto(Long id, String context, Long taskId, LocalDateTime createdAt, Long createdBy, LocalDateTime updatedAt, Long updatedBy) {
        super(id);
        this.context = context;
        this.taskId = taskId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}
