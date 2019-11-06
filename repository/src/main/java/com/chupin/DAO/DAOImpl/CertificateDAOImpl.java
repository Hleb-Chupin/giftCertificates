package com.chupin.DAO.DAOImpl;

import com.chupin.DAO.CertificateDAO;
import com.chupin.model.Certificate;
import com.chupin.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class CertificateDAOImpl implements CertificateDAO {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Certificate> getAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Certificate> allCertificates = em.createQuery("SELECT c FROM Certificate c", Certificate.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return allCertificates;
    }

    @Override
    public Certificate getById(long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Certificate certificate = em.find(Certificate.class, id);
        em.close();
        return certificate;
    }

    @Override
    public long save(Certificate certificate) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(certificate);
        em.getTransaction().commit();
        em.close();
        return certificate.getId();
    }

    @Override
    public void update(Certificate certificate) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(certificate);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Certificate certificate) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(certificate));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Set<Certificate> getByTag(Tag tag) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Set<Certificate> allCertificatesByTag = em.find(Tag.class, tag.getId())
                .getCertificates();
        em.getTransaction().commit();
        em.close();
        return allCertificatesByTag;
    }

    @Override
    public List<Certificate> getByPartOfName(String name) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Certificate> allCertificatesByPartOfName = em.createQuery("SELECT c FROM Certificate c WHERE c.certificateName like :name")
                .setParameter("name", "%" + name + "%")
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return allCertificatesByPartOfName;
    }

    @Override
    public List<Certificate> getSortedCertificatesByName() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Certificate> allCertificatesSortedByName = em.createQuery("SELECT c FROM Certificate c ORDER BY c.certificateName ASC")
                .getResultList();
        em.getTransaction().commit();
        em.close();
        return allCertificatesSortedByName;
    }
}
