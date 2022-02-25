package com.example.trello.dto.permission;

import com.example.trello.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionCreateDto implements Dto {
    private String code;
    private String name;
}
