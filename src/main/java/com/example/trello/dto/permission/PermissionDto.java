package com.example.trello.dto.permission;

import com.example.trello.dto.GenericDto;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionDto extends GenericDto {
    private Long id;
    private String code;
    private String name;

    @Builder(builderMethodName = "childBuilder")
    public PermissionDto(Long id, Long id1, String code, String name) {
        super(id);
        this.id = id1;
        this.code = code;
        this.name = name;
    }
}
