package com.example.trello.services;

import com.example.trello.criteria.GenericCriteria;
import com.example.trello.dto.GenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService <
        D extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable > {

    List<D> getAll(C criteria);

    D get (K id);

    Long totalCount (C criteria);

    default Void block (K id) {
        return null;
    }

    default Void unblock (K id) {
        return null;
    }

    default Void archive (K id) {
        return null;
    }

    default Void unarchive (K id) {
        return null;
    }

    default Void close (K id) {
        return null;
    }

    default List<D> getAllByTaskId(K id) {
        return null;
    }

    default List<D> getAllByOrgId(K id) {
        return null;
    }



}
