package com.example.trello.services.auth;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.auth.UserCreateDto;
import com.example.trello.dto.auth.UserDto;
import com.example.trello.dto.auth.UserUpdateDto;
import com.example.trello.entity.auth.AuthUser;
import com.example.trello.mapper.AuthUserMapper;
import com.example.trello.repository.AuthUserRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.auth.AuthUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthUserServiceImpl extends AbstractService<AuthUserRepository, AuthUserMapper, AuthUserValidator> implements AuthUserService {

    @Autowired
    public AuthUserServiceImpl(AuthUserRepository repository, AuthUserMapper mapper, AuthUserValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(UserCreateDto createDto) {
        AuthUser user = mapper.fromCreateDto(createDto);
        repository.save(user);
        return user.getId();
    }

    @Override
    public Void update(UserUpdateDto updateDto) {
        AuthUser user = mapper.fromUpdateDto(updateDto);
        repository.save(user);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<UserDto> getAll(GenericCriteria criteria) {
        List<AuthUser> users = repository.findAll();
        return mapper.toDto(users);
    }

    @Override
    public UserDto get(Long id) {
        AuthUser user = repository.getById(id);
        return mapper.toDto(user);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


    @Override
    public List<UserDto> getAllByOrgId(Long id)  {
        List<AuthUser> authUsers = repository.findAllByOrganization_Id(id);
        return mapper.toDto(authUsers);
    }

    @Override
    public List<UserDto> getAllAdminsByOrgId(Long id) {
        List<AuthUser> authUsers = repository.findAllByOrganization_Id(id);
        List<Long> userId = null;
        for (AuthUser authUser : authUsers) {
              userId.add(authUser.getId());
            }

        return null;
    }
}
