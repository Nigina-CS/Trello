package com.example.trello.dto.organization;

import com.example.trello.dto.Dto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class OrganizationCreateDto implements Dto {
    private String name;
    private MultipartFile logo;
    private String code;
    private String email;

    public OrganizationCreateDto(String name, MultipartFile logo, String code, String email) {
        this.name = name;
        this.code = code;
        this.email = email;
        this.logo = logo;
    }
}