package DAO.DAOImpl;

import DAO.CertificateDAO;
import model.Certificate;
import model.Tag;

import java.util.List;

public class CertificateDAOImpl implements CertificateDAO {

    @Override
    public List<Certificate> getAll() {
        return null;
    }

    @Override
    public List<Certificate> getByTag(Tag tag) {
        return null;
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
        return null;
    }

    @Override
    public void save(Certificate certificate, Tag tag) {

    }

    @Override
    public void update(Certificate certificate, Tag tag) {

    }

    @Override
    public void delete(Certificate certificate) {

    }
}
