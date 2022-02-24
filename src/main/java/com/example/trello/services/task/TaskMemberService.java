package com.example.trello.services.task;

import com.example.trello.dto.auth.UserDto;
import com.example.trello.dto.task.TaskMemberDto;
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
public class TaskMemberService implements BaseService {
    private final AuthUserRepository repository;
    private final AuthUserMapper mapper;

    public TaskMemberService(AuthUserRepository repository, AuthUserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Void add(TaskMemberDto dto) {
        ProjectMember member;
        for (Long aLong : dto.getUserId()) {
            repository.addProjectMember(aLong,dto.getTaskId());
        }
        return null;
    }

    public List<UserDto> get(Long id) {
        List<Long> users = repository.getTaskMembers(id);
        List<Optional<AuthUser>> authUsers = null;
        for (Long user : users) {
            authUsers.add(repository.findById(user));
        }
        List<AuthUser> user = authUsers.stream().flatMap(Optional::stream).collect(Collectors.toList());
        return mapper.toDto(user);
    }
}
