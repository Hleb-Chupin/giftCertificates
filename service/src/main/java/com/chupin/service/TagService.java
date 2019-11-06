package com.chupin.service;

import com.chupin.model.Tag;

import java.util.List;

public interface TagService {

    int createTag(Tag tag);

    List<Tag> getTagList();

    Tag getTag(int id);

    void updateTag(Tag tag);

    void deleteTag(Tag tag);
}
