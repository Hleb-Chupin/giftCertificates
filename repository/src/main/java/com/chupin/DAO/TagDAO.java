package com.chupin.DAO;

import com.chupin.model.Tag;

import java.util.List;

public interface TagDAO {

    List<Tag> getAll();

    Tag getById(long id);

    long save(Tag tag);

    void update(Tag tag);

    void delete(Tag tag);
}
