package com.example.trello.services.project;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.project.ProjectCreateDto;
import com.example.trello.dto.project.ProjectDto;
import com.example.trello.dto.project.ProjectUpdateDto;
import com.example.trello.entity.project.Project;
import com.example.trello.mapper.ProjectMapper;
import com.example.trello.repository.ProjectRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.project.ProjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractService<ProjectRepository, ProjectMapper, ProjectValidator>
        implements ProjectService{

    private final ProjectValidator validator;

    @Autowired
    protected ProjectServiceImpl(ProjectRepository repository, ProjectMapper mapper, ProjectValidator validator) {
        super(repository, mapper, validator);
        this.validator = validator;
    }

    @Override
    public Long create(ProjectCreateDto createDto) {
        Project project = mapper.fromCreateDto(createDto);
        repository.save(project);
        return project.getId();
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Void update(ProjectUpdateDto updateDto) {
        Project project = mapper.fromUpdateDto(updateDto);
        repository.save(project);
        return null;
    }

    @Override
    public List<ProjectDto> getAll(GenericCriteria criteria) {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public ProjectDto get(Long id) {
        Project project = repository.findById(id).orElseThrow(() -> new RuntimeException("Project was not found"));
        return mapper.toDto(project);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }

    @Override
    @Query(value = "update Project p set p.archived = true where p.id = :id")
    public Void archive(@Param("id") Long id) {
        return null;
    }

    @Override
    @Query(value = "update Project p set p.archived = false where p.id = :id")
    public Void unarchive(@Param("id") Long id) {
        return null;
    }

    @Override
    @Query(value = "update Project p set p.closed = true where p.id = :id")
    public Void close(@Param("id") Long id) {
        return null;
    }

}
