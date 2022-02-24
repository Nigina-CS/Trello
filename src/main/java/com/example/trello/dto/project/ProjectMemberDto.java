package com.example.trello.dto.project;

import com.example.trello.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberDto implements Dto {
    private List<Long> userId;
    private Long projectId;

}
