package com.chupin.DAO.DAOImpl;

import com.chupin.DAO.TagDAO;
import com.chupin.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class TagDAOImpl implements TagDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Tag> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Tag> allTags = em.createQuery("SELECT t FROM Tag t", Tag.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return allTags;
    }

    @Override
    public Tag getById(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Tag tag = em.find(Tag.class, id);
        em.getTransaction().commit();
        em.close();
        return tag;
    }

    @Override
    public long save(Tag tag) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(tag);
        em.getTransaction().commit();
        em.close();
        return tag.getId();
    }

    @Override
    public void update(Tag tag) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(tag);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Tag tag) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(tag));
        em.getTransaction().commit();
        em.close();
    }
}
