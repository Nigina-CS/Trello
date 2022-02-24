package com.example.trello.dto.task;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
public class TaskMemberDto {
    private List<Long> userId;
    private Long taskId;
}
