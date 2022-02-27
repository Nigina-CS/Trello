package com.example.trello.mapper;

import com.example.trello.dto.organization.OrganizationCreateDto;
import com.example.trello.dto.organization.OrganizationDto;
import com.example.trello.dto.organization.OrganizationUpdateDto;
import com.example.trello.entity.organization.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface OrganizationMapper extends BaseMapper <
        Organization,
        OrganizationDto,
        OrganizationCreateDto,
        OrganizationUpdateDto> {
    @Override
    OrganizationDto toDto(Organization organization);

    @Override
    List<OrganizationDto> toDto(List<Organization> e);

    @Override
    Organization fromCreateDto(OrganizationCreateDto organizationCreateDto);

    @Override
    Organization fromUpdateDto(OrganizationUpdateDto d);
}
