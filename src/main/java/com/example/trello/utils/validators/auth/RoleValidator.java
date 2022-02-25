package com.example.trello.utils.validators.auth;

import com.example.trello.dto.role.RoleCreateDto;
import com.example.trello.dto.role.RoleUpdateDto;
import com.example.trello.exception.ValidationException;
import com.example.trello.utils.BaseUtils;
import com.example.trello.utils.validators.AbstractValidator;
import com.example.trello.utils.validators.Validator;
import org.springframework.stereotype.Component;


@Component
public class RoleValidator extends AbstractValidator<RoleCreateDto, RoleUpdateDto, Long> implements Validator {

    protected RoleValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(RoleCreateDto roleCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(RoleUpdateDto cd) throws ValidationException {

    }
}
