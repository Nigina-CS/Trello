package com.example.trello.utils.validators.auth;

import com.example.trello.dto.permission.PermissionCreateDto;
import com.example.trello.dto.permission.PermissionUpdateDto;
import com.example.trello.exception.ValidationException;
import com.example.trello.utils.BaseUtils;
import com.example.trello.utils.validators.AbstractValidator;
import com.example.trello.utils.validators.Validator;
import org.springframework.stereotype.Component;


@Component
public class PermissionValidator extends AbstractValidator<PermissionCreateDto, PermissionUpdateDto, Long> implements Validator {
    protected PermissionValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(PermissionCreateDto cd) throws ValidationException {

    }

    @Override
    public void validOnUpdate(PermissionUpdateDto ud) throws ValidationException {

    }
}
