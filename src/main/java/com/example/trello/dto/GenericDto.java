package com.example.trello.dto;

import com.example.trello.entity.Auditable;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericDto implements Dto{
    private Long id;

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
        //return 17;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Auditable other = (Auditable) obj;
        return Objects.equals(id,other.getId());
        //return id != null && id.equals(other.getId());
    }
}
