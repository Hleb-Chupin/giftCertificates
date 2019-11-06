package com.chupin.service.impl;

import com.chupin.DAO.TagDAO;
import com.chupin.model.Tag;
import com.chupin.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    TagDAO tagDAO;

    @Override
    public int createTag(Tag tag) {
        return tagDAO.save(tag);
    }

    @Override
    public List<Tag> getTagList() {
        return tagDAO.getAll();
    }

    @Override
    public Tag getTag(int id) {
        return tagDAO.getById(id);
    }

    @Override
    public void updateTag(Tag tag) {
        tagDAO.update(tag);
    }

    @Override
    public void deleteTag(Tag tag) {
        tagDAO.delete(tag);
    }
}
