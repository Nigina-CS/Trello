package com.example.trello.dto.auth;

import com.example.trello.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class UserUpdateDto extends GenericDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profile;
    private boolean active;
    private Long roleId;

    @Builder(builderMethodName = "childBuilder")
    public UserUpdateDto(Long id, String firstName, String lastName, String email, String password, String profile, boolean active, Long roleId) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.profile = profile;
        this.active = active;
        this.roleId = roleId;
    }
}
