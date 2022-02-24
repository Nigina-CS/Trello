package com.example.trello.services.project;

import com.example.trello.dto.auth.UserDto;
import com.example.trello.dto.project.ProjectMemberDto;
import com.example.trello.entity.auth.AuthUser;
import com.example.trello.entity.project.ProjectMember;
import com.example.trello.mapper.AuthUserMapper;
import com.example.trello.repository.AuthUserRepository;
import com.example.trello.services.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectMemberService implements BaseService {

    private final AuthUserRepository repository;
    private final AuthUserMapper mapper;

    public ProjectMemberService(AuthUserRepository repository, AuthUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Void add(ProjectMemberDto dto) {
        ProjectMember member;
        for (Long aLong : dto.getUserId()) {
            repository.addProjectMember(aLong,dto.getProjectId());
        }
        return null;
    }

    public List<UserDto> get(Long id) {
        List<Long> users = repository.getProjectMembers(id);
        List<Optional<AuthUser>> authUsers = null;
        for (Long user : users) {
            authUsers.add(repository.findById(user));
        }
        List<AuthUser> user = authUsers.stream().flatMap(Optional::stream).collect(Collectors.toList());
        return mapper.toDto(user);
    }
}
