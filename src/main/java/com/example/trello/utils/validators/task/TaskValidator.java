package com.example.trello.utils.validators.task;

import com.example.trello.dto.project.ProjectCreateDto;
import com.example.trello.dto.project.ProjectUpdateDto;
import com.example.trello.exception.ValidationException;
import com.example.trello.utils.BaseUtils;
import com.example.trello.utils.validators.AbstractValidator;
import com.example.trello.utils.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class TaskValidator  extends AbstractValidator<ProjectCreateDto, ProjectUpdateDto,Long>
        implements Validator {
    protected TaskValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(ProjectCreateDto projectCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(ProjectUpdateDto cd) throws ValidationException {

    }
}
