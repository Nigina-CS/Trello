package com.example.trello.utils.validators.organization;

import com.example.trello.dto.organization.OrganizationCreateDto;
import com.example.trello.dto.organization.OrganizationUpdateDto;
import com.example.trello.exception.ValidationException;
import com.example.trello.utils.BaseUtils;
import com.example.trello.utils.validators.AbstractValidator;
import com.example.trello.utils.validators.Validator;
import org.springframework.stereotype.Component;

@Component
public class OrganizationValidator extends AbstractValidator<OrganizationCreateDto,OrganizationUpdateDto,Long>
        implements Validator {

    public OrganizationValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(OrganizationCreateDto organizationCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(OrganizationUpdateDto cd) throws ValidationException {

    }
}
