package com.example.trello.services.task;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.task.TaskCreateDto;
import com.example.trello.dto.task.TaskDto;
import com.example.trello.dto.task.TaskUpdateDto;
import com.example.trello.entity.task.Task;
import com.example.trello.mapper.TaskMapper;
import com.example.trello.repository.TaskRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.task.TaskValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractService<TaskRepository, TaskMapper, TaskValidator>
        implements TaskService {
    public TaskServiceImpl(TaskRepository repository,  TaskMapper mapper, TaskValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(TaskCreateDto createDto) {
        Task task = mapper.fromCreateDto(createDto);
        repository.save(task);
        return task.getId();
    }

    @Override
    public Void update(TaskUpdateDto updateDto) {
        Task task = mapper.fromUpdateDto(updateDto);
        repository.save(task);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<TaskDto> getAll(GenericCriteria criteria) {
        return null;
    }


    public List<TaskDto> getAllTaskByColumnName(Long id,String name) {
        List<Task> allByProject_id = repository.findAllByProject_Id(id,name);
        return mapper.toDto(allByProject_id);
    }

    @Override
    public TaskDto get(Long id) {
        Task task = repository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Not found");
        });
        return mapper.toDto(task);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }
}
