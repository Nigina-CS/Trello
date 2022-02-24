package com.example.trello.utils.validators.comment;

import com.example.trello.dto.comment.CommentCreateDto;
import com.example.trello.dto.comment.CommentUpdateDto;
import com.example.trello.exception.ValidationException;
import com.example.trello.utils.BaseUtils;
import com.example.trello.utils.validators.AbstractValidator;
import org.springframework.stereotype.Component;

@Component
public class CommentValidator extends AbstractValidator<CommentCreateDto, CommentUpdateDto,Long> {
    protected CommentValidator(BaseUtils baseUtils) {
        super(baseUtils);
    }

    @Override
    public void validateKey(Long id) throws ValidationException {

    }

    @Override
    public void validOnCreate(CommentCreateDto commentCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(CommentUpdateDto cd) throws ValidationException {

    }
}
