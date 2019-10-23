package DAO;

import model.Tag;

import java.util.List;

public interface TagDAO {

    List<Tag> getAll();

    Tag getById(int id);

    void save(Tag tag);

    void update(Tag tag);

    void delete(Tag tag);
}
