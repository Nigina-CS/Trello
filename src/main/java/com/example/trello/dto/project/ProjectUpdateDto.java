package com.example.trello.dto.project;

import com.example.trello.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProjectUpdateDto extends GenericDto {

    private String name;
    private boolean closed;

    @Builder(builderMethodName = "childBuilder")
    public ProjectUpdateDto(Long id, String name, boolean closed) {
        super(id);
        this.name = name;
        this.closed = closed;
    }
}
