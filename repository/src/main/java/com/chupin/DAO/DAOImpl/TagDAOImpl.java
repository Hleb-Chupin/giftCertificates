package com.chupin.DAO.DAOImpl;

import com.chupin.DAO.TagDAO;
import com.chupin.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TagDAOImpl implements TagDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Tag> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Tag").list();
    }

    @Override
    public Tag getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Tag.class, id);
    }

    @Override
    public int save(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(tag);
        return tag.getId();
    }

    @Override
    public void update(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.update(tag);

    }

    @Override
    public void delete(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(tag);
    }
}
