package com.example.trello.dto.comment;

import com.example.trello.dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class CommentUpdateDto extends GenericDto {
    private String context;
    private Long updatedBy;


    @Builder(builderMethodName = "childBuilder")
    public CommentUpdateDto(Long id, String context, Long updatedBy) {
        super(id);
        this.context = context;
        this.updatedBy = updatedBy;
    }
}
