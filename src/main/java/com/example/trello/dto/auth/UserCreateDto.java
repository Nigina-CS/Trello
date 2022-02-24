package com.example.trello.dto.auth;

import com.example.trello.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto implements Dto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profile;
    private Long organizationId;
    private Long roleId;

}
