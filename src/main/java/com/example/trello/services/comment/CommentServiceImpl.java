package com.example.trello.services.comment;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.comment.CommentCreateDto;
import com.example.trello.dto.comment.CommentDto;
import com.example.trello.dto.comment.CommentUpdateDto;
import com.example.trello.entity.comment.Comment;
import com.example.trello.mapper.CommentMapper;
import com.example.trello.repository.CommentRepository;
import com.example.trello.services.AbstractService;
import com.example.trello.utils.validators.comment.CommentValidator;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentServiceImpl extends AbstractService<
        CommentRepository,
        CommentMapper,
        CommentValidator>
        implements CommentService {

    public CommentServiceImpl(CommentRepository repository, CommentMapper mapper, CommentValidator validator) {
        super(repository, mapper, validator);
    }

    @Override
    public Long create(CommentCreateDto createDto) {
        Comment comment = mapper.fromCreateDto(createDto);
        repository.save(comment);
        return comment.getId();
    }

    @Override
    public Void update(CommentUpdateDto updateDto) {
        Comment comment = mapper.fromUpdateDto(updateDto);
        repository.save(comment);
        return null;
    }

    @Override
    public Void delete(Long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<CommentDto> getAll(GenericCriteria criteria) {
        return null;
    }

    @Override
    public CommentDto get(Long id) {
        Comment comment = repository.getById(id);
        return mapper.toDto(comment);
    }

    @Override
    public Long totalCount(GenericCriteria criteria) {
        return null;
    }


    @Override
    public List<CommentDto> getAllByTaskId(Long id) {
        List<Comment> comments = repository.findAllByTask_Id(id);
        return mapper.toDto(comments);

    }
}
