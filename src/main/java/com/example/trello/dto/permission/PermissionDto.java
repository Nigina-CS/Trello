package com.example.trello.dto.permission;

import com.example.trello.dto.Dto;
import com.example.trello.dto.GenericDto;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
public class PermissionDto implements Dto {
    private Long id;
    private String code;
    private String name;

    @Builder(builderMethodName = "childBuilder")
    public PermissionDto(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
}
