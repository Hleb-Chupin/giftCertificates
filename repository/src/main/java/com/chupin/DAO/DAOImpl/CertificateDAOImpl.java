package com.chupin.DAO.DAOImpl;

import com.chupin.DAO.CertificateDAO;
import com.chupin.model.Certificate;
import com.chupin.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class CertificateDAOImpl implements CertificateDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Certificate> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Certificate").list();
    }

    @Override
    public List<Certificate> getByTag(Tag tag) {
        Session session = sessionFactory.getCurrentSession();
        List<Certificate> certificateList = session.createQuery("from Certificate").list();
        List<Certificate> certificateListByTag = new ArrayList<>();
//        for (Certificate certificate : certificateList) {
//            if (certificate.getTags().equals(tag)) {
//                certificateListByTag.add(certificate);
//            }
//        }
        return certificateListByTag;
    }

    @Override
    public List<Certificate> getByPartOfName(Tag tag) {
        return null;
    }

    @Override
    public List<Certificate> getSortedCertificatesByName() {
        return null;
    }

    @Override
    public Certificate getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Certificate.class, id);
    }

    @Override
    public int save(Certificate certificate, Set<Tag> tagList) {
        Session session = sessionFactory.getCurrentSession();
        certificate.setTags(tagList);
        session.persist(certificate);
        return certificate.getId();

    }

    @Override
    public void update(Certificate certificate, Set<Tag> tagList) {
        Session session = sessionFactory.getCurrentSession();
        certificate.setTags(tagList);
        session.update(certificate);
    }

    @Override
    public void delete(Certificate certificate) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(certificate);
    }
}
