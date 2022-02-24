package com.example.trello.services.organization;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.organization.OrganizationCreateDto;
import com.example.trello.dto.organization.OrganizationDto;
import com.example.trello.dto.organization.OrganizationUpdateDto;
import com.example.trello.entity.organization.Organization;
import com.example.trello.mapper.OrganizationMapper;
import com.example.trello.repository.OrganizationRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.organization.OrganizationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl extends AbstractService<OrganizationRepository, OrganizationMapper, OrganizationValidator>
        implements OrganizationService {


    @Autowired
    protected OrganizationServiceImpl(OrganizationRepository repository,  OrganizationMapper mapper, OrganizationValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(OrganizationCreateDto createDto) {
        Organization organization = mapper.fromCreateDto(createDto);
        repository.save(organization);
        return organization.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(OrganizationUpdateDto updateDto) {
        Organization organization = mapper.fromUpdateDto(updateDto);
        repository.save(organization);
        return null;
    }

    @Override
    public List<OrganizationDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        return mapper.toDto(organization);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


    @Override
    public Void block(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        organization.setBlocked(true);
        repository.save(organization);
        return null;
    }

    @Override
    public Void unblock(Long id) {
        Organization organization = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        organization.setBlocked(false);
        repository.save(organization);
        return null;
    }
}
